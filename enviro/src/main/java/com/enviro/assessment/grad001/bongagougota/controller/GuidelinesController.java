package com.enviro.assessment.grad001.bongagougota.controller;

import com.enviro.assessment.grad001.bongagougota.dto.GuidelineDto;
import com.enviro.assessment.grad001.bongagougota.dto.Response;
import com.enviro.assessment.grad001.bongagougota.exceptions.InvalidRegionException;
import com.enviro.assessment.grad001.bongagougota.model.Guideline;
import com.enviro.assessment.grad001.bongagougota.service.GuidelineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/guidelines", produces = MediaType.APPLICATION_JSON_VALUE)
public class GuidelinesController {
    private final GuidelineService guidelineService;

    public GuidelinesController(GuidelineService guidelineService) {
        this.guidelineService = guidelineService;
    }

    @PostMapping("/post")
    public ResponseEntity<Guideline> postGuideline(@RequestBody GuidelineDto guideline) throws InvalidRegionException {
        Guideline guideline1 = guidelineService.createGuideline(guideline);
        return new ResponseEntity<>(guideline1, HttpStatus.CREATED);
    }

    @GetMapping("/{guideLineId}")
    public ResponseEntity<Guideline> getGuideline(@PathVariable int guideLineId){
        return new ResponseEntity<>(guidelineService.getGuidelineById(guideLineId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Guideline> updateGuideLineById(@RequestBody Guideline guideline) {
        Guideline guideline1 = guidelineService.updateGuideline(guideline);
        return new ResponseEntity<>(guideline1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<Guideline>> getAllGuidelines() {
        return new ResponseEntity<>(guidelineService.getAllGuidelines(), HttpStatus.OK);
    }

    @DeleteMapping("/{guidelineId}")
    public ResponseEntity<Response> deleteGuidelineById(@PathVariable int guidelineId) {
        if(guidelineService.deleteGuidelineById(guidelineId)){
            return new ResponseEntity<>(new Response("deleted","204", LocalDateTime.now()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package com.enviro.assessment.grad001.bongagougota.controller;

import com.enviro.assessment.grad001.bongagougota.dto.GuidelineDto;
import com.enviro.assessment.grad001.bongagougota.exceptions.InvalidRegionException;
import com.enviro.assessment.grad001.bongagougota.model.Guideline;
import com.enviro.assessment.grad001.bongagougota.service.GuidelineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/guidelines/", produces = MediaType.APPLICATION_JSON_VALUE)
public class GuidelinesController {
    private final GuidelineService guidelineService;

    public GuidelinesController(GuidelineService guidelineService) {
        this.guidelineService = guidelineService;
    }

    @PostMapping("")
    public ResponseEntity<Guideline> postGuideline(@RequestBody GuidelineDto guideline) throws InvalidRegionException {
        Guideline guideline1 = guidelineService.createGuideline(guideline);
        return new ResponseEntity<>(guideline1, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Guideline> updateGuideLineById(@RequestBody Guideline guideline) {
        Guideline guideline1 = guidelineService.updateGuideline(guideline);
        return new ResponseEntity<>(guideline1, HttpStatus.OK);
    }

    @DeleteMapping("{guidelineId}")
    public ResponseEntity<Guideline> deleteGuidelineById(@PathVariable int guidelineId) {
        if(guidelineService.deleteGuidelineById(guidelineId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

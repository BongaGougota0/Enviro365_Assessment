package com.enviro.assessment.grad001.bongagougota.controller;

import com.enviro.assessment.grad001.bongagougota.exceptions.InvalidRegionException;
import com.enviro.assessment.grad001.bongagougota.model.Guideline;
import com.enviro.assessment.grad001.bongagougota.service.GuidelineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/guidelines/", produces = MediaType.APPLICATION_JSON_VALUE)
public class GuidelinesController {
    private final GuidelineService guidelineService;

    public GuidelinesController(GuidelineService guidelineService) {
        this.guidelineService = guidelineService;
    }

    @PostMapping("")
    public ResponseEntity<Guideline> postGuideline(@RequestBody Guideline guideline) throws InvalidRegionException {
        Guideline guideline1 = guidelineService.createGuideline(guideline);
        return new ResponseEntity<>(guideline1, HttpStatus.CREATED);
    }
}

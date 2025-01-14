package com.enviro.assessment.grad001.bongagougota.controller;

import com.enviro.assessment.grad001.bongagougota.service.GuidelineService;
import com.enviro.assessment.grad001.bongagougota.service.RecyclingTipsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
@RequestMapping(path="/api/info", produces= MediaType.APPLICATION_JSON_VALUE)
public class Enviro365InformationController {
    private final GuidelineService guidelineService;
    private final RecyclingTipsService recyclingTipsService;

    public Enviro365InformationController(GuidelineService guidelineService, RecyclingTipsService recyclingTipsService) {
        this.guidelineService = guidelineService;
        this.recyclingTipsService = recyclingTipsService;
    }

    @GetMapping("/categories")
    public ResponseEntity<ArrayList<String>> getCategories() {
        return ResponseEntity.ok().body(guidelineService.getGuidelineCategories());
    }
}

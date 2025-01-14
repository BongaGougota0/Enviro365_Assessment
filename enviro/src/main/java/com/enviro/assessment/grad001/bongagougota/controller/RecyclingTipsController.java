package com.enviro.assessment.grad001.bongagougota.controller;

import com.enviro.assessment.grad001.bongagougota.dto.Response;
import com.enviro.assessment.grad001.bongagougota.exceptions.InvalidRegionException;
import com.enviro.assessment.grad001.bongagougota.model.RecyclingTip;
import com.enviro.assessment.grad001.bongagougota.service.RecyclingTipsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/recycling", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecyclingTipsController {

    private final RecyclingTipsService recyclingTipsService;

    public RecyclingTipsController(RecyclingTipsService recyclingTipsService) {
        this.recyclingTipsService = recyclingTipsService;
    }

    @PostMapping("/post")
    public ResponseEntity<RecyclingTip> postRecyclingTip(@RequestBody RecyclingTip recyclingTip) throws InvalidRegionException {
        RecyclingTip recyclingTip1 = recyclingTipsService.createRecyclingTip(recyclingTip);
        return ResponseEntity.ok().body(recyclingTip1);
    }

    @GetMapping("/{recyclingTipId}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable int recyclingTipId) {
        RecyclingTip recyclingTip = recyclingTipsService.getRecyclingTipById(recyclingTipId);
        return ResponseEntity.ok().body(recyclingTip);
    }

    @PutMapping("/update")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        RecyclingTip recyclingTip1 = recyclingTipsService.updateRecyclingTip(recyclingTip);
        return ResponseEntity.ok().body(recyclingTip1);
    }

    @DeleteMapping("/{recyclingTipId}")
    public ResponseEntity<Response> deleteRecyclingTipById(@PathVariable int recyclingTipId) {
        boolean isDeleted =  recyclingTipsService.deleteRecyclingTipById(recyclingTipId);
        if(isDeleted){
        return new ResponseEntity(new Response("deleted","204", LocalDateTime.now()), HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    public ResponseEntity<ArrayList<RecyclingTip>> getRecyclingTipsByCategory(@RequestParam(value = "category") String category) {
        ArrayList<RecyclingTip> recyclingTipArrayList = recyclingTipsService.getRecyclingTipByCategory(category);
        return ResponseEntity.ok().body(recyclingTipArrayList);
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<RecyclingTip>> getAllRecyclingTips() {
        return ResponseEntity.ok().body(recyclingTipsService.getAllRecyclingTips());
    }


}

package com.enviro.assessment.grad001.bongagougota.controller;

import com.enviro.assessment.grad001.bongagougota.dto.Response;
import com.enviro.assessment.grad001.bongagougota.model.Waste;
import com.enviro.assessment.grad001.bongagougota.service.WasteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping(path="/api/waste", produces = MediaType.APPLICATION_JSON_VALUE)
public class WasteController {
    WasteService wasteService;

    public WasteController(WasteService wasteService) {
        this.wasteService = wasteService;
    }

    @PostMapping("/post")
    public ResponseEntity<Waste> createWaste(@Valid @RequestBody Waste waste) {
        Waste waste1 = wasteService.saveWasteObject(waste);
        return ResponseEntity.ok().body(waste1);
    }

    @GetMapping( "/all")
    public ResponseEntity<ArrayList<Waste>> getAllWaste() {
        ArrayList<Waste> wasteArrayList = wasteService.getAllWastes();
        if (wasteArrayList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok().body(wasteArrayList);
    }

    @PutMapping("/update")
    public ResponseEntity<Waste> updateWaste(@RequestBody Waste waste) {
        Waste updatedWasteObject = wasteService.updateWasteObject(waste);
        return ResponseEntity.ok().body(updatedWasteObject);
    }

    @GetMapping("/{wasteId}")
    public ResponseEntity<Waste> getWaste(@PathVariable int wasteId) {
        Waste waste = wasteService.getWasteById(wasteId);
        return ResponseEntity.ok().body(waste);
    }

    @DeleteMapping("/delete/{wasteId}")
    public ResponseEntity<Response> deleteWaste(@PathVariable int wasteId) {
        boolean isDeleted = wasteService.deleteWasteById(wasteId);
        if (isDeleted) {
            return ResponseEntity.ok().body(new Response("deleted","204", LocalDateTime.now()));
        }
        return ResponseEntity.ok().body(new Response("error","404", LocalDateTime.now()));
    }
}

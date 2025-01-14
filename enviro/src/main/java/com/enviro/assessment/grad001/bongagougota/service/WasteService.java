package com.enviro.assessment.grad001.bongagougota.service;

import com.enviro.assessment.grad001.bongagougota.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.bongagougota.model.Waste;
import com.enviro.assessment.grad001.bongagougota.repository.WasteRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class WasteService {

    private final WasteRepository wasteRepository;

    public WasteService(WasteRepository wasteRepository) {
        this.wasteRepository = wasteRepository;
    }

    public ArrayList<Waste> getAllWastes() {
        return (ArrayList<Waste>) wasteRepository.findAll();
    }

    public Waste saveWasteObject(Waste waste) {
        return wasteRepository.save(waste);
    }

    public Waste updateWasteObject(Waste waste) {
        return wasteRepository.findById(waste.getId()).map(
                wasteObj -> {
                    wasteObj.setWasteCategory(waste.getWasteCategory());
                    wasteObj.setWasteDescription(waste.getWasteDescription());
                    return wasteRepository.save(wasteObj);
                }
        ).orElseThrow(() -> new RuntimeException("Waste object not found"));
    }

    public Waste getWasteById(int wasteId) {
        return wasteRepository.findById(wasteId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Waste data with id %s not found.", wasteId)));
    }

    public boolean deleteWasteById(int wasteId) {
        Waste deleteWasteObj =  wasteRepository.findById(wasteId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Waste with id %s not found.", wasteId)));
        wasteRepository.delete(deleteWasteObj);
        return true;
    }
}

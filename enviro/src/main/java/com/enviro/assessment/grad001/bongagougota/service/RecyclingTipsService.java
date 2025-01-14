package com.enviro.assessment.grad001.bongagougota.service;

import com.enviro.assessment.grad001.bongagougota.exceptions.InvalidRegionException;
import com.enviro.assessment.grad001.bongagougota.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.bongagougota.model.RecyclingTip;
import com.enviro.assessment.grad001.bongagougota.model.WasteCategory;
import com.enviro.assessment.grad001.bongagougota.repository.RecyclingTipsRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class RecyclingTipsService {
    private final RecyclingTipsRepository recyclingTipsRepository;

    public RecyclingTipsService(RecyclingTipsRepository recyclingTipsRepository) {
        this.recyclingTipsRepository = recyclingTipsRepository;
    }

    public RecyclingTip getRecyclingTipById(int id) {
        return recyclingTipsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Recycling tip with id %s not found", id)));
    }

    public ArrayList<RecyclingTip> getAllRecyclingTips() {
        return (ArrayList<RecyclingTip>) recyclingTipsRepository.findAll();
    }

    public ArrayList<RecyclingTip> getRecyclingTipByCategory(String categoryName) {
        ArrayList<RecyclingTip> recyclingTips = new ArrayList<>();
       recyclingTips = recyclingTipsRepository.findAll()
                .stream()
                .filter(recyclingTip -> recyclingTip.getCategory().equalsIgnoreCase(categoryName))
                .collect(Collectors.toCollection(ArrayList::new));
        return recyclingTips;
    }

    public RecyclingTip createRecyclingTip(RecyclingTip recyclingTip) throws InvalidRegionException {
        try {
            return recyclingTipsRepository.save(recyclingTip);
        } catch (RuntimeException e) {
            throw new InvalidRegionException("Accepted Waste Category values " + Arrays.toString(WasteCategory.values()));
        }
    }

    public RecyclingTip updateRecyclingTip(RecyclingTip recyclingTip) {
        return recyclingTipsRepository.findById(recyclingTip.getId()).map(recyclingTip1 -> {
                    recyclingTip1.setDescription(recyclingTip.getDescription());
                    recyclingTip1.setTitle(recyclingTip.getTitle());
                    recyclingTip1.setCategory(recyclingTip.getCategory());
                    return recyclingTipsRepository.save(recyclingTip1);
                })
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Update error: Recycling tip with id %s not found",recyclingTip.getId())));
    }

    public boolean deleteRecyclingTipById(int id) {
       RecyclingTip recyclingTip = recyclingTipsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("Delete error: Recycling tip with id %s not found", id)));
        recyclingTipsRepository.delete(recyclingTip);
        return true;
    }
}

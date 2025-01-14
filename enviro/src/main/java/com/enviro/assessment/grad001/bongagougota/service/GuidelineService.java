package com.enviro.assessment.grad001.bongagougota.service;

import com.enviro.assessment.grad001.bongagougota.exceptions.InvalidRegionException;
import com.enviro.assessment.grad001.bongagougota.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.bongagougota.model.Guideline;
import com.enviro.assessment.grad001.bongagougota.model.WasteCategory;
import com.enviro.assessment.grad001.bongagougota.repository.GuidelineRepository;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class GuidelineService {
    private final GuidelineRepository guidelineRepository;
    public GuidelineService(GuidelineRepository guidelineRepository) {
        this.guidelineRepository = guidelineRepository;
    }

    public Guideline getGuidelineById(int id) {
        return guidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Guideline with id %s not found", id)));
    }

    public ArrayList<String> getGuidelineCategories() {
        return Arrays.stream(WasteCategory.values())
                .map(WasteCategory::name)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Guideline> getAllGuidelines() {
        return (ArrayList<Guideline>) guidelineRepository.findAll();
    }

    public ArrayList<Guideline> getGuidelinesByCategory(String categoryName) {
        ArrayList<Guideline> guidelines = new ArrayList<>();
        guidelines = guidelineRepository.findAll()
                .stream()
                .filter(guideline -> guideline.getWasteCategory().toString().equalsIgnoreCase(categoryName))
                .collect(Collectors.toCollection(ArrayList::new));
        return guidelines;
    }

    public Guideline createGuideline(Guideline guideline) throws InvalidRegionException {
        try {
            return guidelineRepository.save(guideline);
        } catch (HttpMessageNotReadableException e) {
            throw new InvalidRegionException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Guideline updateGuideline(Guideline guideline) {
        return guidelineRepository.findById(guideline.getId()).map(guide -> {
             guide.setGuideLineDescription(guideline.getGuideLineDescription());
             guide.setGuideLineTitle(guideline.getGuideLineTitle());
             guide.setWasteCategory(guideline.getWasteCategory());
             return guidelineRepository.save(guide);
                })
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Update error: Guideline with id %s not found", guideline.getId())));
    }

    public boolean deleteGuidelineById(int id) {
        Guideline guideline = guidelineRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("Delete error: Guideline with id %s not found", id)));
        guidelineRepository.delete(guideline);
        return true;
    }
}

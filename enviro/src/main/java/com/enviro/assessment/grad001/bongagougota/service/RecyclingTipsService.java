package com.enviro.assessment.grad001.bongagougota.service;

import com.enviro.assessment.grad001.bongagougota.repository.RecyclingTipsRepository;
import org.springframework.stereotype.Service;

@Service
public class RecyclingTipsService {
    private final RecyclingTipsRepository recyclingTipsRepository;

    public RecyclingTipsService(RecyclingTipsRepository recyclingTipsRepository) {
        this.recyclingTipsRepository = recyclingTipsRepository;
    }
}

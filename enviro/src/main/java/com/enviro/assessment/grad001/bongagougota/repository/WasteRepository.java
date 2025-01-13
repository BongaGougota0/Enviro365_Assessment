package com.enviro.assessment.grad001.bongagougota.repository;

import com.enviro.assessment.grad001.bongagougota.model.Waste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRepository extends JpaRepository<Waste, Integer> {
    Waste removeWasteById(int wasteId);
}

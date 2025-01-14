package com.enviro.assessment.grad001.bongagougota.repository;

import com.enviro.assessment.grad001.bongagougota.model.Waste;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteRepository extends JpaRepository<Waste, Integer> {
    @Transactional
    Waste removeWasteById(int wasteId);
}

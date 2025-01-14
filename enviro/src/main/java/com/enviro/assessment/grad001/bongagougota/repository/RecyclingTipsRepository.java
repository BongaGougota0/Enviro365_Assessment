package com.enviro.assessment.grad001.bongagougota.repository;

import com.enviro.assessment.grad001.bongagougota.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipsRepository extends JpaRepository<RecyclingTip, Integer> {
}

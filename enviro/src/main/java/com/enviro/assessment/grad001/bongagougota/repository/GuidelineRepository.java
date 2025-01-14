package com.enviro.assessment.grad001.bongagougota.repository;

import com.enviro.assessment.grad001.bongagougota.model.Guideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuidelineRepository extends JpaRepository<Guideline, Integer> {
}

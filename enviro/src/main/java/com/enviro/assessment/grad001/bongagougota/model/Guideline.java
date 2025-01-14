package com.enviro.assessment.grad001.bongagougota.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "guidelines")
@Data
public class Guideline extends BaseEntity{
    @Id
    private int id;
    private WasteCategory wasteCategory;
    private String guideLineTitle;
    private String guideLineDescription;
}

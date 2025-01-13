package com.enviro.assessment.grad001.bongagougota.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "waste")
public class Waste extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    int id;
    WasteCategory wasteCategory;
    String wasteDescription;
}

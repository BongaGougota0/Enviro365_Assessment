package com.enviro.assessment.grad001.bongagougota.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity(name = "waste")
@Data
public class Waste extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    public int id;

    public WasteCategory wasteCategory;

    @NotBlank(message="Waste description is required, this assists in identifying waste category.")
    @Size(min=10, message="Description must be at least 10 characters long.")
    public String wasteDescription;
}

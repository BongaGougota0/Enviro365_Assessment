package com.enviro.assessment.grad001.bongagougota.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "guidelines")
@Data
public class Guideline extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Enumerated(EnumType.STRING)
    private WasteCategory wasteCategory;

    @NotBlank
    @Size(min=5, message="Guideline title must be at least 5 characters long")
    private String guideLineTitle;

    @NotBlank
    @Size(min=15, message="Guideline description must be at least 15 characters long")
    private String guideLineDescription;
}

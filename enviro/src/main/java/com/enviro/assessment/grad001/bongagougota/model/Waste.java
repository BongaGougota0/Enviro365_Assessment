package com.enviro.assessment.grad001.bongagougota.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity(name = "waste")
@Data
public class Waste extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    public int id;

    @NotBlank(message="Waste title required.")
    @Size(min=5, message="Title must be at least 5 characters long.")
    public String wasteTitle;

    @Enumerated(EnumType.STRING)
    @NotNull
    public WasteCategory wasteCategory;

    @NotBlank(message="Waste description is required, this assists in identifying waste category.")
    @Size(min=15, message="Description must be at least 15 characters long.")
    public String wasteDescription;
}

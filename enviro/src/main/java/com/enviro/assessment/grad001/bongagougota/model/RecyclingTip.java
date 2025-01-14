package com.enviro.assessment.grad001.bongagougota.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity(name = "recycling_tips")
@Data
public class RecyclingTip extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Size(min=5, message="Title must be at least 5 characters long")
    private String title;

    @Size(min=15, message="Description must be at least 15 characters long")
    private String description;

    private String category;
}

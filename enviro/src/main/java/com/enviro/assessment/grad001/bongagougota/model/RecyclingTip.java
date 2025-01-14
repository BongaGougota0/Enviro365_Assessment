package com.enviro.assessment.grad001.bongagougota.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "recycling_tips")
@Data
public class RecyclingTip extends BaseEntity {
    @Id
    private int id;
}

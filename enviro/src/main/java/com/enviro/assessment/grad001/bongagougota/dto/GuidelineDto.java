package com.enviro.assessment.grad001.bongagougota.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GuidelineDto {
    @NotNull
    public String guideLineTitle;
    @NotNull
    public String guideLineDescription;
    @NotNull
    public String wasteCategory;
}

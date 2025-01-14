package com.enviro.assessment.grad001.bongagougota.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String successMessage;
    private String successCode;
    private LocalDateTime timestamp;
}
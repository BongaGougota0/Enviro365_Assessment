package com.enviro.assessment.grad001.bongagougota.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;


public class BaseEntity {
    @JsonIgnore
    @CreatedDate
    LocalDateTime createdAt;

    @JsonIgnore
    @LastModifiedDate
    LocalDateTime updatedAt;
}

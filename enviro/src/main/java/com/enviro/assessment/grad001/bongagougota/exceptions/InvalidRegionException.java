package com.enviro.assessment.grad001.bongagougota.exceptions;

import com.enviro.assessment.grad001.bongagougota.model.WasteCategory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRegionException extends Exception{
    public InvalidRegionException(String message){
        super(message);
    }
}

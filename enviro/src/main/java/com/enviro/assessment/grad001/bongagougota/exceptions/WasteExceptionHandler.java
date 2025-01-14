package com.enviro.assessment.grad001.bongagougota.exceptions;

import com.enviro.assessment.grad001.bongagougota.dto.ErrorResponse;
import com.enviro.assessment.grad001.bongagougota.model.WasteCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class WasteExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> noResourceFoundExceptionHandler(Exception ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(),
                HttpStatus.NOT_FOUND.name(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> illegalArgExceptionHandler(Exception ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(),
                HttpStatus.BAD_REQUEST.name(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidRegionException.class})
    public ResponseEntity<ErrorResponse> invalidRegionExceptionHandler(Exception ex){
        ErrorResponse error = new ErrorResponse(" Accepted Waste Category values " + Arrays.toString(WasteCategory.values()),
                "400", LocalDateTime.now());
        return ResponseEntity.badRequest().body(error);
    }
}

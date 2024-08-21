package com.akshai.DoctorMs.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    ResponseEntity<String> handleDoctorNotFound(DoctorNotFoundException ex){
        log.error("given id is incorrect so no doctor record found");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

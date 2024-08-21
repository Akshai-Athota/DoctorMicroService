package com.akshai.DoctorMs.Exception;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String messagae){
        super(messagae);
    }
}

package com.akshai.DoctorMs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;

    @Size(min = 10,max = 10)
    private String contactNumber;

    @Email
    private String email;
    private String specialty;
}

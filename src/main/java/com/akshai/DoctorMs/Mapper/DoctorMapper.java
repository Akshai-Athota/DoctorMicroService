package com.akshai.DoctorMs.Mapper;

import com.akshai.DoctorMs.Entity.Doctor;
import com.akshai.DoctorMs.dto.DoctorDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorMapper {
    Doctor toEntity(DoctorDTO doctorDTO);
    DoctorDTO toDTO(Doctor doctor);
}

package com.akshai.DoctorMs.Service;

import com.akshai.DoctorMs.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    DoctorDTO createDoctor(DoctorDTO doctorDTO);
    DoctorDTO getDoctorById(Long id);
    List<DoctorDTO> getAllDoctors();
    List<DoctorDTO> getDoctorsBySpecialty(String specialty);
    DoctorDTO updateDoctorById(Long id,DoctorDTO doctorDTO);
    void deleteDoctorById(Long id);
}

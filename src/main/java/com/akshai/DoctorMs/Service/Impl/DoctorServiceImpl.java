package com.akshai.DoctorMs.Service.Impl;

import com.akshai.DoctorMs.Entity.Doctor;
import com.akshai.DoctorMs.Exception.DoctorNotFoundException;
import com.akshai.DoctorMs.Mapper.DoctorMapper;
import com.akshai.DoctorMs.Repository.DoctorRepository;
import com.akshai.DoctorMs.Service.DoctorService;
import com.akshai.DoctorMs.dto.DoctorDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorMapper doctorMapper;
    private DoctorRepository doctorRepository;
    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        return doctorMapper.toDTO(doctorRepository.save(doctorMapper.toEntity(doctorDTO)));
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        return doctorMapper.toDTO(doctorRepository.findById(id)
                .orElseThrow(()->new DoctorNotFoundException("doctor with given id not present")));
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(x->doctorMapper.toDTO(x)).collect(Collectors.toList());
    }

    @Override
    public List<DoctorDTO> getDoctorsBySpecialty(String specialty) {
        return doctorRepository.findByspecialty(specialty).stream()
                .map(x->doctorMapper.toDTO(x)).collect(Collectors.toList());
    }

    @Override
    public DoctorDTO updateDoctorById(Long id, DoctorDTO doctorDTO) {
        Doctor doctor= doctorRepository.findById(id)
                .orElseThrow(()->new DoctorNotFoundException("no doctor found with given id"));
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setSpecialty(doctorDTO.getSpecialty());
        doctor.setContactNumber(doctorDTO.getContactNumber());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setAddress(doctorDTO.getAddress());
        return doctorMapper.toDTO(doctorRepository.save(doctor));
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
}

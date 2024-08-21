package com.akshai.DoctorMs.Controller;

import com.akshai.DoctorMs.Service.DoctorService;
import com.akshai.DoctorMs.dto.DoctorDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/doctor")
@Slf4j
public class DoctorController {
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        log.info("Fetching all doctors");
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
        log.info("Fetching doctor with id: {}", id);
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @GetMapping("/specialty/{specialty}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsBySpecialty(@PathVariable String specialty) {
        log.info("Fetching doctors with specialty: {}", specialty);
        return ResponseEntity.ok(doctorService.getDoctorsBySpecialty(specialty));
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        log.info("Creating new doctor: {} {}", doctorDTO.getFirstName(), doctorDTO.getLastName());
        return ResponseEntity.ok(doctorService.createDoctor(doctorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) {
        log.info("Updating doctor with id: {}", id);
        return ResponseEntity.ok(doctorService.updateDoctorById(id, doctorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        log.info("Deleting doctor with id: {}", id);
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }
}

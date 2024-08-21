package com.akshai.DoctorMs.Repository;

import com.akshai.DoctorMs.Entity.Doctor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>  {
    List<Doctor> findByspecialty(String specialty);
}

package com.patient.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

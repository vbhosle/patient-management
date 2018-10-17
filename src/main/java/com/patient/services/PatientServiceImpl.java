package com.patient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.patient.entities.Patient;
import com.patient.repos.PatientRepository;

@Component
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository repository;
	
	@Override
	public Patient createPatient(Patient patient) {
		return repository.save(patient);
	}

	@Override
	public Patient updatePatienet(Patient patient) {
		return repository.save(patient);
	}

	@Override
	public void deletePatient(Patient patient) {
		repository.delete(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		return repository.findAll();
	}

	@Override
	public Patient getPatientById(Long id) {
		return repository.findById(id).get();
	}

}

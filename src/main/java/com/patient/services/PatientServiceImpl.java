package com.patient.services;

import java.util.List;
import java.util.NoSuchElementException;

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
	public Patient updatePatient(Patient patient) {
		return repository.save(patient);
	}

	@Override
	public void deletePatient(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Patient> getAllPatients() {
		return repository.findAll();
	}

	@Override
	public Patient getPatientById(Long id) {
		Patient patient = null;
		try {
			patient = repository.findById(id).get();
		}
		catch(NoSuchElementException ex) {
			System.out.println("No such Patient for id "+ id);
		}
		return patient;
	}

}

package com.patient.services;

import java.util.List;

import com.patient.entities.Patient;

public interface PatientService {
	
	public Patient createPatient(Patient patient);
	
	public Patient updatePatienet(Patient patient);
	
	public void deletePatient(Patient patient);
	
	public List<Patient> getAllPatients();
	
	public Patient getPatientById(Long id);
	
}

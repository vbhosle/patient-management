package com.patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patient.entities.Patient;
import com.patient.services.PatientService;

@RestController
@RequestMapping("/")
public class PatientRestController {

	@Autowired
	PatientService patientService;

	@RequestMapping(
			value = "patients", 
			method = { RequestMethod.POST }, 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		ResponseEntity<Patient> responseEntity;
		
		if(patient.getId()!=null) {
			Patient existingPatient = patientService.getPatientById(patient.getId());
			if(existingPatient != null) {
				return new ResponseEntity<>(existingPatient, HttpStatus.CONFLICT);
			}
		}
		
		Patient createdPatient = patientService.createPatient(patient);
		responseEntity = new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
		return responseEntity;
	}

	@RequestMapping(
			value = "patients", 
			method = { RequestMethod.GET }, 
			produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}
}

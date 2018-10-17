package com.patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
			method = { RequestMethod.PUT }, 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
		ResponseEntity<Patient> responseEntity;
		
		if(patient.getId()!=null) {
			Patient existingPatient = patientService.getPatientById(patient.getId());
			if(existingPatient == null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		Patient updatedPatient = patientService.updatePatient(patient);
		responseEntity = new ResponseEntity<>(updatedPatient, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(
			value="patients/{id}",
			method= {RequestMethod.DELETE}
	)
	public ResponseEntity<Void> deletePatientById(@PathVariable("id") Long id) {
		Patient existingPatient = patientService.getPatientById(id);
		if(existingPatient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		patientService.deletePatient(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(
			value="patients/{id}",
			method= {RequestMethod.GET},
			produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id) {
		Patient existingPatient = patientService.getPatientById(id);
		if(existingPatient == null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(existingPatient, HttpStatus.OK);
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

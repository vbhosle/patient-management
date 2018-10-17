package com.patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
			method = { RequestMethod.GET }, 
			produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}
}

package com.patient.app;

import java.util.Date;

import org.h2.tools.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patient.entities.Patient;
import com.patient.services.PatientServiceImpl;

public class AppDemo {
	
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//get the h2 console url
		Server server = context.getBean("h2WebServer", Server.class);
		System.out.println(server.getURL());
		PatientServiceImpl service = context.getBean("patientServiceImpl", PatientServiceImpl.class);
		Patient patient = new Patient();
		patient.setName("Test");
		patient.setDob(new Date());
		service.createPatient(patient);
	}
}

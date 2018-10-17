package com.patient.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("patientId")
	private Long id;
	
	@JsonProperty("patientName")
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="IST")
	@JsonProperty("dateOfBirth")
	private Date dob;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date birth) {
		this.dob = birth;
	}

	public Long getId() {
		return id;
	}

}

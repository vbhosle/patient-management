package com.patient.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("patientId")
	private Long id;
	
	@JsonProperty("patientName")
	@NotNull(message="patientName is required")
	@NotBlank(message="patientName can't be empty")
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="IST")
	@JsonProperty("dateOfBirth")
	@NotNull(message="dateofBirth is required")
	@Past(message="dateOfBirth can't be the future date")
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

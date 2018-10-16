package com.patient.entities;

import java.util.Date;

public class Patient {

	private Long id;
	private String name;
	private Date birth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Long getId() {
		return id;
	}

}

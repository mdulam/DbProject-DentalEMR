package com.uncc.ad.dentalemr.app;

public class AppointmentDetails {
	String date, time, name, speciality,doctor;
	
	public AppointmentDetails() {
		
	}

	public AppointmentDetails(String date, String time, String name, String speciality, String doctor) {
		super();
		this.date = date;
		this.time = time;
		this.name = name;
		this.speciality = speciality;
		this.doctor = doctor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "AppointmentDetails [date=" + date + ", time=" + time + ", name=" + name + ", speciality=" + speciality
				+ ", doctor=" + doctor + "]";
	}
	
}

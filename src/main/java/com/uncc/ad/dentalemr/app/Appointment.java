package com.uncc.ad.dentalemr.app;

public class Appointment {
	String patientId, employeeId, date, time;
	
	public Appointment() {
		
	}

	public Appointment(String patientId, String employeeId, String date, String time) {
		super();
		this.patientId = patientId;
		this.employeeId = employeeId;
		this.date = date;
		this.time = time;
	}

}

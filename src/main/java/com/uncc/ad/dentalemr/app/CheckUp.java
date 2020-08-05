package com.uncc.ad.dentalemr.app;

public class CheckUp {
	String id ;
	public CheckUp(String id, String employeeId, String appointmentDate,String symptoms, String diagnosis, String testOrder, String testResult,
			String prescription, String comments) {
		super();
		this.id = id;
		this.employeeId=employeeId;
		this.appointmentDate=appointmentDate;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.testOrder = testOrder;
		this.testResult = testResult;
		this.prescription = prescription;
		this.comments = comments;
	}

	String employeeId;
	String appointmentDate;
	String symptoms ;
	String diagnosis ;
	String testOrder ;
	String testResult ;
	String prescription ;
	String comments ;
	
	public CheckUp() {
		
	}
	
	
}

package com.uncc.ad.dentalemr.app;

public class Employee {
	String id, name, phNo, email, speciality, fee;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public Employee() {
		
	}

	public Employee(String id, String name, String phNo, String email, String speciality, String fee) {
		super();
		this.id = id;
		this.name = name;
		this.phNo = phNo;
		this.email = email;
		this.speciality = speciality;
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phNo=" + phNo + ", email=" + email + ", speciality="
				+ speciality + ", fee=" + fee + "]";
	}
	
	
	
	

}

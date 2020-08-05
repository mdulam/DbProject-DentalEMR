package com.uncc.ad.dentalemr.app;

public class SignUp {
	String firstName, lastName, gender, dateOfBirth, phoneNo, email, password, adLine1, adLine2, city, state, country, zipCode, insuranceComp, insuranceNo;

	public SignUp(String firstName, String lastName, String gender, String dateOfBirth, String phoneNo, String email,String password,
			String adLine1, String adLine2, String city, String state, String country, String zipCode,
			String insuranceComp, String insuranceNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password=password;
		this.adLine1 = adLine1;
		this.adLine2 = adLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.insuranceComp = insuranceComp;
		this.insuranceNo = insuranceNo;
	}
	

}

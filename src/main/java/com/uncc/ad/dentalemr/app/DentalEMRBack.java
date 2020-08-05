package com.uncc.ad.dentalemr.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DentalEMRBack {

	
	@Autowired
	JdbcTemplate executeQuery;
	
	public List<Inventory> getInventoryDetails() {
		return executeQuery.query("SELECT * FROM Inventory", (rs, num) -> new Inventory(rs.getInt("inventory_id"), rs.getInt("medicine_id"), rs.getInt("stock_remaining")));
	}
	
	public boolean InsertPatientDetails(SignUp signUp)  {
		/*
		 * String query ="call insertPatientDetails (\""+ signUp.firstName+"\",\""+
		 * signUp.lastName+"\",\""+ signUp.gender+"\",\""+
		 * signUp.dateOfBirth+"\",\""+signUp.phoneNo+"\",\""+ signUp.email+"\",\""+
		 * signUp.password+"\",\""+ signUp.adLine1+"\",\""+signUp.adLine2+"\",\""+
		 * signUp.city+"\",\""+ signUp.state+"\",\""+
		 * signUp.country+"\",\""+signUp.zipCode+"\",\""+ signUp.insuranceComp+"\",\""+
		 * signUp.insuranceNo+"\");";
		 */
	
	int count =executeQuery.update(new PreparedStatementCreator() {
		 
        public PreparedStatement createPreparedStatement(Connection con)
                throws SQLException {
            PreparedStatement stmt = con.prepareStatement("CALL insertPatientDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            stmt.setString(1, signUp.firstName);
            stmt.setString(2, signUp.lastName);
            stmt.setString(3, signUp.gender);
            stmt.setString(4, signUp.dateOfBirth);
            stmt.setString(5, signUp.phoneNo);
            stmt.setString(6, signUp.email);
            stmt.setString(7, signUp.password);
            stmt.setString(8, signUp.adLine1);
            stmt.setString(9, signUp.adLine2);
            stmt.setString(10, signUp.city);
            stmt.setString(11, signUp.state);
            stmt.setString(12, signUp.country);
            stmt.setString(13, signUp.zipCode);
            stmt.setString(14, signUp.insuranceComp);
            stmt.setString(15, signUp.insuranceNo);

            return stmt;
            
        }
    });
	System.out.print(count);
	return count>0 ? true:false;
	}
	
	public boolean InsertAppointmentDetails(Appointment appointment)  {
	
	int count =executeQuery.update(new PreparedStatementCreator() {
		 
        public PreparedStatement createPreparedStatement(Connection con)
                throws SQLException {
            PreparedStatement stmt = con.prepareStatement("CALL book_appointment(?,?,?,?);");
            stmt.setString(1, appointment.patientId);
            stmt.setString(2, appointment.date);
            stmt.setString(3, appointment.time);
            stmt.setString(4, appointment.employeeId);
            return stmt;
            
        }
    });
	System.out.print(count);
	return count>0 ? true:false;
	}
	
	public List<AppointmentDetails> GetAppointmentDetails(String patientId)
	{
		String query="CALL get_appointmentDetailsByPatientId(?);";
				
		List<AppointmentDetails> appointmentDetails = executeQuery.query(
				query,
			    new Object[] {patientId},
			    new RowMapper<AppointmentDetails>() {
			        public AppointmentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	AppointmentDetails c = new AppointmentDetails();
			            c.name=rs.getString(5);
			            c.speciality= rs.getString(6) ;
			            c.time= String.valueOf(rs.getTime(4));
			            c.date=String.valueOf(rs.getDate(3));
			            c.doctor=rs.getString(7);
			            return c;
			        }
			    });
		return appointmentDetails;
	}
	
	public List<Patient> getPatientDetails()
	{
		String query="select patient_Id, Concat (first_name, \" \", last_name ) as patient_name from patient where patient_id= (select Max(patient_Id) from patient );\r\n" + "";

		
		List<Patient> patientDetails = executeQuery.query(
				query,
			    new RowMapper<Patient>() {
			        public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Patient c = new Patient();
			            c.patientId=rs.getString(1);
			            c.patientName=rs.getString(2);
			            return c;
			        }
			    });
		return patientDetails;
	}
	
	public List<Login> getEmployeeLoginCredentials(String userName, String password)
	{
		String query="select * from EmployeeLogin where user_name=? and password=?;";
				
		List<Login> loginDetails = executeQuery.query(
				query,
			    new Object[] {userName, password},
			    new RowMapper<Login>() {
			        public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Login c = new Login();
			            c.userName=rs.getString(2);
			            c.password= rs.getString(3) ;
			            c.role= rs.getString(4);
			            return c;
			        }
			    });
		return loginDetails;
	}
	
	public List<Login> getPatientLoginCredentials(String userName, String password)
	{
		String query="select * from patient where patient_email=? and password=?;";
				
		List<Login> loginDetails = executeQuery.query(
				query,
			    new Object[] {userName, password},
			    new RowMapper<Login>() {
			        public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Login c = new Login();
			            c.userName=rs.getString(7);
			            c.password= rs.getString(8) ;
			            c.role= "patient";
			            return c;
			        }
			    });
		return loginDetails;
	}
	
	public List<Employee> getEmployeeDetails()
	{
		String query="call getAllEmployeeDetails();";
				
		List<Employee> loginDetails = executeQuery.query(
				query,
			    new RowMapper<Employee>() {
			        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Employee c = new Employee();
			            c.id=String.valueOf(rs.getInt(1));
			            c.name= rs.getString(2) ;
			            c.phNo= rs.getString(3) ;
			            c.email=rs.getString(4) ;
			            c.speciality= rs.getString(5) ;
			            c.fee= String.valueOf(rs.getInt(6));
			            return c;
			        }
			    });
		return loginDetails;
	}
	
	public boolean updateEmployeeDetails(Employee employee)  {
		
	
	int count =executeQuery.update(new PreparedStatementCreator() {
		 
        public PreparedStatement createPreparedStatement(Connection con)
                throws SQLException {
            PreparedStatement stmt = con.prepareStatement("CALL updateEmployeeDetails(?,?,?,?,?);");
            stmt.setString(1, employee.id);
            stmt.setString(2, employee.phNo);
            stmt.setString(3, employee.email);
            stmt.setString(4, employee.speciality);
            stmt.setString(5, employee.fee);
            return stmt;
            
        }
    });
	System.out.print(count);
	return count>0 ? true:false;
	}
	
	public boolean insertCheckUpDetails(CheckUp checkUp)  {
		
		
	int count =executeQuery.update(new PreparedStatementCreator() {
		 
        public PreparedStatement createPreparedStatement(Connection con)
                throws SQLException {
            PreparedStatement stmt = con.prepareStatement("CALL insert_checkUp_details(?,?,?,?,?, ?,?,?,?);");
            stmt.setString(1, checkUp.id);
            stmt.setString(2, checkUp.employeeId);
            stmt.setString(3, checkUp.appointmentDate);
            stmt.setString(4, checkUp.symptoms);
            stmt.setString(5, checkUp.diagnosis);
            stmt.setString(6, checkUp.testOrder);
            stmt.setString(7, checkUp.testResult);
            stmt.setString(8, checkUp.prescription);
            stmt.setString(9, checkUp.comments);
            return stmt;
            
        }
    });
	System.out.print(count);
	return count>0 ? true:false;
	}
	
}
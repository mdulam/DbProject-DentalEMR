package com.uncc.ad.dentalemr.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DentalEMRFront {

	@Autowired
	DentalEMRBack DentalEMRBack;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String displayHello(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "hello";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String displayLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "Login";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String sayHello(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String phNo = request.getParameter("phNo");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String adL1 = request.getParameter("AdL1");
		String adL2 = request.getParameter("AdL2");
		String city = request.getParameter("City");
		
		String zip = request.getParameter("Zip");
		String inComp = request.getParameter("InComp");
		String inNo = request.getParameter("InNo");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String [] arrayDate = dateOfBirth.split("/");
		
		StringBuilder builder = new StringBuilder();
		builder.append(arrayDate[2]);
		builder.append("-");
		builder.append(arrayDate[0]);
		builder.append("-");
		builder.append(arrayDate[1]);
		
		SignUp obj = new SignUp(fname, lname, gender, builder.toString(), phNo, email, password, adL1, adL2, city, "NC",
				"USA", zip, inComp, inNo);
		boolean isInserted = DentalEMRBack.InsertPatientDetails(obj);

		System.out.println("Value is : " + isInserted);

		if (isInserted) {
			
			return "redirect:/BookAnAppointment";
			
		} else {
			return "hello";
		}
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String getData(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<Inventory> list = DentalEMRBack.getInventoryDetails();

		StringBuilder builder = new StringBuilder();
		for (Inventory inventory : list) {
			builder.append(inventory.toString());
		}

		model.addAttribute("data", builder.toString());

		return "data";
	}

	@RequestMapping(value = "/BookAnAppointment", method = RequestMethod.GET)
	public String getAppointmentDetails(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		/*
		 * List<Patient> patient = DentalEMRBack.getPatientDetails();
		 * model.addAttribute("patientId",patient.get(0).patientId );
		 * model.addAttribute("IdPatient", patient.get(0).patientId);
		 */
		return "BookAnAppointment";
	}

	@RequestMapping(value = "/BookAnAppointment", method = RequestMethod.POST)
	public String InsertAppointmentDetails(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		String patientId = request.getParameter("patientId");
		String EmployeeId = request.getParameter("employee");
		String Date = request.getParameter("date");
		String Time = request.getParameter("time");
		String enteredId = request.getParameter("IdPatient");
		if (enteredId != null) {
			List<AppointmentDetails> appointmentList = DentalEMRBack.GetAppointmentDetails(enteredId);
			model.addAttribute("listUsers", appointmentList);

		}
		if (patientId != null && EmployeeId != null && Date != null && Time != null) {
			String[] dateArray = Date.split("/");
			StringBuilder builder = new StringBuilder();
			builder.append(dateArray[2]);
			builder.append("-");
			builder.append(dateArray[0]);
			builder.append("-");
			builder.append(dateArray[1]);

			Appointment obj = new Appointment(patientId, EmployeeId, builder.toString(), Time);
			boolean isInserted = DentalEMRBack.InsertAppointmentDetails(obj);
			System.out.println("Value is : " + isInserted);

			if (isInserted) {
				return "BookAnAppointment";
			} else {
				return "BookAnAppointment";
			}
		}
		return "BookAnAppointment";

	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String getLoginCredentials(HttpServletRequest request, HttpServletResponse response, ModelMap model ) {

		String pUser = request.getParameter("puname");
		String pPass = request.getParameter("ppsw");
		String eUser = request.getParameter("euname");
		String ePass = request.getParameter("epsw");

		if (pUser != null && pPass != null) {
			List<Login> isPresent = DentalEMRBack.getPatientLoginCredentials(pUser, pPass);
			if (isPresent.size() > 0) {
				if ((isPresent.get(0).userName).length() != 0) {
					return "redirect:/BookAnAppointment";
					
				}
			} else {
				 return "redirect:/Login";
			}
			
		}

		if (eUser != null && ePass != null) {
			List<Login> isPresent = DentalEMRBack.getEmployeeLoginCredentials(eUser, ePass);
			if (isPresent.size() > 0) {
				if ((isPresent.get(0).userName).length() != 0) {
					if(isPresent.get(0).role.equals("Admin")) {
						
						 return "redirect:/admin";
					}
					
					else if (isPresent.get(0).role.equals("Doctor")) {
						 return "redirect:/doctor";
						
					}		
				}
			} else {
				
				 return "redirect:/Login";
			
			}
		}

		
		 return "redirect:/Login";

	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getEmployeeDetails(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<Employee> employeeDetails =DentalEMRBack.getEmployeeDetails();
		model.addAttribute("listEmployee", employeeDetails);
		return "admin";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String updateEmployeeDetails(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		String id = request.getParameter("empId");
		String name = request.getParameter("userName");
		String phno = request.getParameter("contactNo");
		String email = request.getParameter("email");
		String speciality = request.getParameter("speciality");
		String fee = request.getParameter("fee");
		Employee objEmp = new Employee(id, name,phno, email, speciality,fee);
		boolean isUpdated = DentalEMRBack.updateEmployeeDetails(objEmp);
		if(isUpdated) {
			List<Employee> employeeDetails =DentalEMRBack.getEmployeeDetails();
			model.addAttribute("listEmployee", employeeDetails);
		}
		
		return "admin";
	}
	
	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public String doctorPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "doctor";
	}
	
	@RequestMapping(value = "/doctor", method = RequestMethod.POST)
	public String getCheckDetails(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String id = request.getParameter("patientId");
		String employeeId = request.getParameter("employeeId");
		String appointmentDate = request.getParameter("appointmentDate");
		String symptoms = request.getParameter("symptoms");
		String diagnosis = request.getParameter("diagnosis");
		String testOrder = request.getParameter("testOrder");
		String testResult = request.getParameter("testResult");
		String prescription = request.getParameter("prescription");
		String comments = request.getParameter("comments");
		
		String[] dateArray = appointmentDate.split("/");
		StringBuilder builder = new StringBuilder();
		builder.append(dateArray[2]);
		builder.append("-");
		builder.append(dateArray[0]);
		builder.append("-");
		builder.append(dateArray[1]);
		
		
		CheckUp objCheckUp = new CheckUp(id,employeeId, builder.toString(), symptoms, diagnosis,testOrder,testResult,prescription, comments );
		boolean isInserted = DentalEMRBack.insertCheckUpDetails(objCheckUp);
		return "doctor";
	}

}
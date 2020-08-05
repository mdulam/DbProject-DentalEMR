<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book an Appointment</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function() {
    $("#datepicker").datepicker();
  });
</script>
<style type="text/css">
body {margin:0;}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  position: fixed;
  top: 0;
  width: 100%;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}


input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
 
  /* padding: 20px; */
}
</style>

</head>
<body>


<div style="height:80px;background-color: #2196F3;text-align: center;color: white;padding-top:10px;display: inline-block;width: 100%;">
    <div style=" width: 80%; float: left;">
    <h1> Charlotte's Dental Clinic </h1></div>
<div style=" width: 20%;float: right;">
        <button type="button" onclick="location.href = 'http://localhost:9091/Login';"  class="btn btn-default btn-sm" style=" width: 30%; color:white; float: right; margin-right: 20px; background-color: black;">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </button>
    </div>
</div>
<div style="display:inline-block; width:100%">
<div style="width:50%;  background-color: #f2f2f2; float:left; padding:20px;">
<h2>Book An Appointment</h2>
 <form action="/BookAnAppointment" method="post">
    <label for="patientId">Patient Id</label>
    <input type="text" id="patientId" name="patientId" placeholder=" Enter your  Patient Id..">

    <label for="lname">Select Employee</label>
    <select id="employee" name="employee">
      <option value="1">Aaron Roy</option>
      <option value="2">Dale Martis</option>
      <option value="3">Gabriel Dsouza</option>
       <option value="4">Harry Shaw</option>
      <option value="5">Bella Weasley</option>
      <option value="6">Jack Gran</option>
      
    </select>

    <label for="date">Date</label>
   <input type="text" name="date" id="datepicker">
   
    <label for="time">Time</label>
    <input type="text" id="lname" name="time" placeholder="Enter the time 24 hr format (13:00:00)..">
  
    <input type="submit" value="Submit">
  </form>
</div>
<div style="width:50%; float:left; padding-left:20px; padding-right:20px;" >
<div>
  <form action="/BookAnAppointment" method="post">
  <h2>Check Appointment History</h2>
  <div style="display:inline-block;">
  <div style="width:50%; float:left; padding:10px;">
   <input type="text" id="IdPatient"  name="IdPatient" placeholder="Enter Patient Id..">
  </div>
  <div style="width:50%; float:left; padding:10px;">
  <input type="submit"  value="Submit">
  </div>
   
    
  </div>
  </form>
</div>
<div class="w3-container">
  <h2>Appointment History</h2>
  <table class="w3-table-all">
    <thead>
      <tr class="w3-red">
        <th>Patient Name</th>
        <th>Date</th>
        <th>Time</th>
         <th>Doctor</th>
          <th>Specialty</th>
      </tr>
    </thead> 
     <c:forEach var="user" items="${listUsers}">
                <tr>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.date}" /></td>
                    <td><c:out value="${user.time}" /></td>
                    <td><c:out value="${user.speciality}" /></td>
                     <td><c:out value="${user.doctor}" /></td>
                </tr>
            </c:forEach>
    
  </table>
</div>
</div>

</div>
</body>
</html>
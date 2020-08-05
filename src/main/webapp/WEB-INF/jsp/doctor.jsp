<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor</title>
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
<h2>Insert CheckUp Details</h2>
 <form action="/doctor" method="post">
<div style="width:50%;  background-color: #f2f2f2; float:left; padding:20px;">
    <label for="patientId">Patient Id</label>
    <input type="text" id="patientId" name="patientId" placeholder=" Enter your  Patient Id..">
    <label for="employeeId">Employee Id</label>
    <input type="text" id="employeeId" name="employeeId" placeholder=" Enter your Id..">
     <label for="symptoms">Symptoms</label>
    <input type="text" id="symptoms" name="symptoms" placeholder=" Enter the Symptoms..">
     <label for="diagnosis">Diagnosis</label>
    <input type="text" id="diagnosis" name="diagnosis" placeholder=" Enter the  diagnosis..">
     <label for="appointmentDate">Date</label>
   <input type="text" name="appointmentDate" id="datepicker">
</div>
<div style="width:50%;  background-color: #f2f2f2; float:left; padding:20px;">
    <label for="testOrder">Order Test</label>
    <select id="testOrder" name="testOrder">
      <option value="Dental X-Ray">Dental X-Ray</option>
      <option value="X-Ray of the root">X-Ray of the root</option>
      <option value="Pulp Vitality test">Pulp Vitality test</option>
       <option value="General Test">General Test</option>
      <option value="No Test">No Test</option>
    </select>

    <label for="testResult">Test Result</label>
    <input type="text" id="testResult" name="testResult" placeholder=" Enter the test Result..">
    <label for="prescription">Prescription</label>
    <select id="prescription" name="prescription">
      <option value="1001">Medicine 1</option>
      <option value="1002">Medicine 2</option>
      <option value="1003">Medicine 3</option>
       <option value="1004">Medicine 4</option>
      <option value="1005">Medicine 5</option>
      <option value="1006">Medicine 6</option>
    </select>
    <label for="comments">Comments</label>
    <input type="text" id="comments" name="comments" placeholder="Enter the Comments..">
</div>
<div style=" padding:20px;"> 
<input style="margin-left: 30px; margin-top: 20px; width: 10%;" type="submit" value="Submit"></div>
</form>
</div>

</body>
</html>
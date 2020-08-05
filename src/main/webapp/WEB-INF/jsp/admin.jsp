<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	// Get the modal
	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}

	function editEmployee(id,name, phNo, email, speciality, fee) {
		document.getElementById('id01').style.display = 'block';
		$('#empId').val(id);
		$('#userName').val(name);
		$('#contactNo').val(phNo);
		$('#email').val(email);
		$('#speciality').val(speciality);
		$('#fee').val(fee);
	}
</script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>
<div style="height:80px;background-color: #2196F3;text-align: center;color: white;padding-top:10px;display: inline-block;width: 100%;">
    <div style=" width: 80%; float: left;">
    <h1> Charlotte's Dental Clinic </h1></div>
<div style=" width: 20%;float: right;">
        <button type="button" onclick="location.href = 'http://localhost:9091/Login';"  class="btn btn-default btn-sm" style=" width: 30%;float: right; color:white; margin-right: 20px; background-color: black;">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </button>
    </div>
</div>
	<div class="w3-container">
		<h2>Employee Details</h2>
		<table class="w3-table-all">
			<thead>
				<tr class="w3-red">
					<th>Employee Id</th>
					<th>Name</th>
					<th>contact No</th>
					<th>Email</th>
					<th>Specialty</th>
					<th>Fees</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach var="user" items="${listEmployee}">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.phNo}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.speciality}" /></td>
					<td><c:out value="${user.fee}" /></td>
					<%-- <td><p style="color: blue; margin:0px;"
							onclick="editEmployee('${user.id}','${user.name}','${user.phNo}', '${user.email}', '${user.speciality}','${user.fee}' )">Edit
						
						<p></td> --%>

<td><button class="button" onclick="editEmployee('${user.id}','${user.name}','${user.phNo}', '${user.email}', '${user.speciality}','${user.fee}' )"  style="background-color:#008CBA; padding:0px; margin:0px;">Edit</button></td>

					<%--  <td><a style="color:blue;" href="editEmployee?id=<c:out value='${user.id}' />">Edit</a></td> --%>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="id01" class="modal">

		<form class="modal-content animate" action="/admin" method="post">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
			<label for="uname"><b>Id</b></label> 
				<input type="text" id="empId" name="empId" readonly> 
				<label for="uname"><b>Name</b></label> 
				<input type="text" id="userName" name="userName" readonly> 
					<label for="uname"><b>Contact No</b></label> 
					<input type="text" id="contactNo" name="contactNo" required>
				<label for="uname"><b>Email</b></label> 
				<input type="text" id="email" name="email" required> 
				<label for="uname"><b>Speciality</b></label>
				<input type="text" id="speciality" name="speciality" required>
				<label for="psw"><b>Fee</b></label> 
				<input type="text" id="fee" name="fee" required>
				<button type="submit">Update</button>
			</div>
		</form>
	</div>
</body>
</html>
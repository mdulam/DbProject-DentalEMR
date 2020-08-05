<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {margin:0;}
.active {
  background-color: #4CAF50;
}


input[type=text],input[type=password], select {
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

.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function() {
    $("#datepicker").datepicker();
  });
</script>
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

<form action="/hello" method="post">
<div style="display:inline-block; width:100%">
<h2>Patient SignUp</h2>
 
<div style="width:50%;  background-color: #f2f2f2; float:left; height: 716px; padding:20px;">
    <label for="firstName">First Name</label>
    <input type="text" id="firstName" name="fname" placeholder=" Enter your First Name..">
    
     <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lname" placeholder=" Enter your Last Name..">
    
    <label for="gender">Gender</label>
	 <select id="gender" name="gender">
      <option value="M">Male</option>
      <option value="F">Female</option>
    </select>
	
	
    <label for="phNo">Phone No</label>
    <input type="text" id="phNo" name="phNo" placeholder=" Enter your Phone No..">
    
     <label for="email">Email</label>
    <input type="text" id="email" name="email" placeholder=" Enter your email..">
    
     <label for="password">Password</label>
    <input type="password" id="password" name="password" placeholder=" Enter your password..">
    
     <label for="dateOfBirth">Date Of Birth</label>
    <input type="text" id="datepicker" name="dateOfBirth" placeholder=" Enter your Date Of Birth..">
    
    
</div>
<div style="width:50%;  background-color: #f2f2f2; float:left; padding:20px;">

    <label for="AdL1">Address Line 1</label>
    <input type="text" id="AdL1" name="AdL1" placeholder=" Enter the Address Line 1..">
    
    <label for="AdL2">Address Line 2</label>
    <input type="text" id="AdL2" name="AdL2" placeholder=" Enter the Address Line 2..">
    
    <label for="City">City</label>
    <select id="City" name="City">
      <option value="1001">Charlotte</option>
      <option value="1002">Raleigh</option>
      <option value="1003">Greensboro</option>
       <option value="1004">Chapel Hill</option>
      <option value="1005">Asheville</option>
      <option value="1006">Cary</option>
    </select>
    <label for="state">State</label>
    <input type="text" id="State" name="State" value="NC" disabled>
    
    <label for="Country">Country</label>
    <input type="text" id="Country" name="Country" value="USA" disabled>
    
     <label for="Zip">ZIP Code</label>
    <input type="text" id="Zip" name="Zip" placeholder=" Enter the Zip Code..">
    
    <label for="InComp">Insurance Company</label>
    <input type="text" id="InComp" name="InComp" placeholder=" Enter your Insurance Company..">
    
    <label for="Zip">Insurance No</label>
    <input type="text" id="InNo" name="InNo" placeholder=" Enter your Insurance No..">
    
    
</div>
</div>
<div style=" padding:20px; text-align:center;"> 
<input style="width: 10%;" type="submit" value="Submit"></div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function emailValid(){
	
	document.getElementById('display').innerHTML ="";
		var email= document.getElementById('eml').value;
		var reg=/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
		var isValid=reg.test(email);
		if(email=="")
			{
			document.getElementById('display').innerHTML = "Field Empty";
			}
		else if(!isValid)
			{
			document.getElementById('display').innerHTML = "Invalid email";
			}
		else
			{
		var xmlhttp = new XMLHttpRequest(); 
		
		xmlhttp.onreadystatechange = function(){ 
			if(xmlhttp.readyState==4&&xmlhttp.status==200){
				document.getElementById('display').innerHTML = xmlhttp.responseText; 
			}
		}
		xmlhttp.open('GET', 'EmailValdaton.jsp?email='+email, true); 
		xmlhttp.send();
			}
	}
</script>
</head>
<body>
<form action="/LibraryUserController" method="post">
	Name:<br>
	<div>
		<input type="text" name="name" required/>
	</div>
	Email:<br>
	<div>
		<input type="email" name="email" id="eml" required onblur="emailValid();"/>
	</div>
	<div id="display"></div>
	Password:<br>
	<div>
		<input type="password" name="password" required/>
	</div>
	Date of Birth:<br>
	<div>
		<input type="date" name="dob" required/>
	</div>
	Gender:<br>
	<div>
		<select name="gender" required>
			<option value="male">Male</option>
			<option value="female">female</option>
		</select>
	</div>
	Occupation:<br>
	<div>
		<input type="text" name="occupation" required>
	</div>
	City:
	<div>
		<select name="city" required>
			<option value="visakhapatnam">vskp</option>
			<option value="hyderabad">hyd</option>
		</select>
	</div>
	Mobile:
	<div>
		<input type="text" name="mobile" required>
	</div>
	<div>
		<button type="submit">Submit</button>
	</div>
</form>
</body>
</html>
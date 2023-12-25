<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file = "menu.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateRegistration</title>
</head>
<body>
<h2>Update Registration</h2>
<form action="UpdateReg" method = "post">

	<pre>
		<input type="hidden" name = "id" value ="${reg.id}"/>
		First Name = <input type="text" name = "firstName" value ="${reg.firstName}"/>
		last Name = <input type="text" name = "lastName" value ="${reg.lastName}"/>
		Email = <input type="text" name = "email" value ="${reg.email}"/>
		Mobile = <input type="text" name = "mobile" value ="${reg.mobile}"/>
		<input type="submit" value="Update">
	</pre>

</form>
${msg}



</body>
</html>
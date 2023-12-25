<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border = "1">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Delete</th>
		<th>Update</th>
	</tr>
	<c:forEach var = "reg" items = "${registration}">
	<tr>
		<td>${reg.firstName}</td>
		<td>${reg.lastName}</td>
		<td>${reg.email}</td>
		<td>${reg.mobile}</td>
		<td><a href ="delete?id=${reg.id}">delete</a> 
		<td><a href ="getRegistrationbyId?id=${reg.id}">update</a> 
		
	</tr>
	</c:forEach>

</table>

</body>
</html>
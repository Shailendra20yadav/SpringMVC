<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details page</title>
</head>
<body>
	<center>
		<h2>Employee Details</h2>
		<table border="1">
		<tr>
		<td> First Name </td><td>Last Name</td>
		</tr>
		<c:forEach items="${employees}" var ="emp">
		<tr>
		<td>${emp.firstname} </td><td>${emp.lastname}</td>
		</tr>
		</c:forEach>
		</table>
		
		
	</center>
</body>
</html>
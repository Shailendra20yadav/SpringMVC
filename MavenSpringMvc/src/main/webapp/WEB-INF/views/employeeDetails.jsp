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
		<h2>Hello World</h2>
		<c:forEach items="employees" var ="emp">
		First Name<h2>${emp.firstName} </h2>
		</c:forEach>
		
	</center>
</body>
</html>
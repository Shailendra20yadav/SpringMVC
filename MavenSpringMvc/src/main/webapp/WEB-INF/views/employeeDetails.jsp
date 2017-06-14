<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
<title>Employee Details page</title>
</head>
<body>
	<center>
		<h2>Employee Details</h2>
		 <%-- <table border="1">
		<tr>
		<td> Employee Number </td><td> First Name </td><td>Last Name</td> <td>Email</td>
		</tr>
		<c:forEach items="${employees}" var ="emp">
		<tr>
			<td>${emp.empid} </td><td>${emp.firstName} </td><td>${emp.lastName}</td><td>${emp.email}</td>
		</tr>
		</c:forEach>
		
		</table>
		--%>
		
		
		 
		<display:table id="txt" class ="sortable-table" pagesize="3" requestURI="/viewAllEmp" name="employees">
		  <display:column property="empid" title="Employee Id" sortable="true"></display:column>
		  <display:column property="firstName" title="First Name" sortable="true"></display:column>
		  <display:column property="lastName" title="last Name" sortable="true"></display:column>
		  <display:column property="email" title="Email" sortable="true"></display:column>
		  <display:column property="userName" title="User Name" sortable="true"></display:column>
		 
		 </display:table>
		 
		<p><a href="home">Home</a> </p>
		
		
	</center>
</body>
</html>
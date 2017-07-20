<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>HRMS</title>
<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<div style="height: 60px;">
		<div style="float: left;">
			<div
				style="float: left; background: #353F48; width: 20px; height: 60px;"></div>
			<div
				style="float: left; background: #C11933; width: 20px; height: 60px;"></div>
			<div style="float: left; height: 60px; padding-left: 30px;">
				<h1>
					<font color="#C11933">HRMS</font>
				</h1>
			</div>
		</div>
		<div style="float: right;">
			<img src="resources/images/logo.png" width="300px;" />
		</div>
	</div>

	<div style="background: #C11933; text-align: center; padding: 8px;">
		<b><font color="white">HRMS Access Denied</font></b>
	</div>
 
	<div style="position: relative; top: 15px;">
		<h1>HTTP Status 403 - Access is denied</h1>
		<c:choose>
			<c:when test="${empty username}">
				<h2>You do not have permission to access this page!</h2>
			</c:when>
			<c:otherwise>
				<h2>
					Username : ${username} <br /> You do not have permission to access
					this page!
				</h2>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>
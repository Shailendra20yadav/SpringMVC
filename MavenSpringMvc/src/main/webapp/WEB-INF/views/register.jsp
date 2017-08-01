<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page isELIgnored="false" %>

        <html>

        <head>
        	<spring:url value="/resources/css/main.css" var="mainCss" />
        	<link href="${mainCss}" rel="stylesheet" />
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

            <title>Registration</title>

        </head>

        <body>

            <form:form id="regForm" modelAttribute="emp" action="registerProcess" method="post">

                <table align="center">

                    <tr>
						<spring:bind path="username">
                        <td>

                            <form:label path="username">Username</form:label>
                        </td>

                        <td>

                            <form:input path="username" name="username" id="username" />
                             <form:errors path="username" class="error-label" />

                        </td>
                        </spring:bind>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="password">Password</form:label>

                        </td>

                        <td>

                            <form:password path="password" name="password" id="password" />
                             <form:errors path="password" class="error-label" />

                        </td>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="firstName">FirstName</form:label>

                        </td>

                        <td>

                            <form:input path="firstName" name="firstName" id="firstName" />
                             <form:errors path="firstName" class="error-label" />

                        </td>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="lastName">LastName</form:label>

                        </td>

                        <td>

                            <form:input path="lastName" name="lastName" id="lastName" />
                             <form:errors path="lastName" class="error-label" />

                        </td>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="email">Email</form:label>

                        </td>

                        <td>

                            <form:input path="email" name="email" id="email" />
                             <form:errors path="email" class="error-label" />

                        </td>

                    </tr>
                    <tr>

                        <td>

                            <form:label path="emproles[0].rolename">Role</form:label>

                        </td>

                        <td>

                           <form:select path="emproles[0].rolename">
   								<%-- <form:option value="NONE" label="--- Select ---"/> --%>
   								<form:options items="${roles}" />
							</form:select>

                        </td>

                    </tr>
                    <tr>

                        <td>

                            <form:label path="enabled">Status</form:label>

                        </td>

                        <td>

                           <form:select path="enabled">
   								<%-- <form:option value="NONE" label="--- Select ---"/> --%>
   								<form:options items="${enableStatus}" />
							</form:select>

                        </td>

                    </tr>

                    <tr>

                        <td></td>

                        <td>

                            <form:button id="register" name="register">Register</form:button>

                        </td>

                    </tr>

                    <tr></tr>

                    <tr>

                        <td></td>

                        <td><a href="home">Home</a>

                        </td>

                    </tr>

                </table>

            </form:form>

        </body>

        </html>
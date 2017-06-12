<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

        <html>

        <head>

            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

            <title>Registration</title>

        </head>

        <body>

            <form:form id="regForm" modelAttribute="emp" action="registerProcess" method="post">

                <table align="center">

                    <tr>
						<spring:bind path="userName">
                        <td>

                            <form:label path="userName">Username</form:label>
                        </td>

                        <td>

                            <form:input path="userName" name="userName" id="userName" />
                             <form:errors path="userName" class="control-label" />

                        </td>
                        </spring:bind>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="password">Password</form:label>

                        </td>

                        <td>

                            <form:password path="password" name="password" id="password" />
                             <form:errors path="password" class="control-label" />

                        </td>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="firstName">FirstName</form:label>

                        </td>

                        <td>

                            <form:input path="firstName" name="firstName" id="firstName" />
                             <form:errors path="firstName" class="control-label" />

                        </td>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="lastName">LastName</form:label>

                        </td>

                        <td>

                            <form:input path="lastName" name="lastName" id="lastName" />
                             <form:errors path="lastName" class="control-label" />

                        </td>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="email">Email</form:label>

                        </td>

                        <td>

                            <form:input path="email" name="email" id="email" />
                             <form:errors path="email" class="control-label" />

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
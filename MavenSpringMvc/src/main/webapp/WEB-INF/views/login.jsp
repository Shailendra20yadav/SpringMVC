<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">

        <html>

        <head>

            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

            <title>Login</title>

        </head>

        <body>

            <form:form id="loginForm" modelAttribute="emp" action="loginProcess" method="post">

                <table align="center">
                	<c:if test="${not empty invalidUserMessage}">
                	<tr><td colspan="2">
                	${invalidUserMessage}
                	</td></tr>
                	</c:if>

                    <tr>
						<spring:bind path="userName">
                        <td>

                            <form:label path="userName">Username: </form:label>

                        </td>

                        <td>

                            <form:input path="userName" name="userName" id="userName" />
                            <form:errors path="userName" class="control-label" />

                        </td>
                        </spring:bind>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="password">Password:</form:label>

                        </td>

                        <td>

                            <form:password path="password" name="password" id="password" />
                            <form:errors path="password" class="control-label" />

                        </td>

                    </tr>

                    <tr>

                        <td></td>

                        <td align="left">

                            <form:button id="login" name="login">Login</form:button>

                        </td>

                    </tr>

                    <tr></tr>

                    <tr>

                        <td></td>

                        <td><a href="home.jsp">Home</a>

                        </td>

                    </tr>

                </table>

            </form:form>

            <table align="center">

                <tr>

                    <td style="font-style: italic; color: red;">${message}</td>

                </tr>

            </table>

        </body>

        </html>
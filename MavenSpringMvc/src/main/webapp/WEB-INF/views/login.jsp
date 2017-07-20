<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">

        <html>

        <head>
			<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

            <title>Login</title>

        </head>

        <body>
        <div style="position: relative; top: 15px;">
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
		</div>
			<c:url value="/j_spring_security_check" var="loginUrl" />
            <%-- <form:form id="loginForm" modelAttribute="emp" action="loginProcess" method="post"> --%>
            <form:form id="loginForm" modelAttribute="emp" action="${loginUrl}" method="post">

                <table align="center">
                	<c:if test="${not empty invalidUserMessage}">
                	<tr><td colspan="2" class="error-label">
                	${invalidUserMessage}
                	</td></tr>
                	</c:if>

                    <tr>
						<spring:bind path="username">
                        <td>

                            <form:label path="username">Username: </form:label>

                        </td>

                        <td>

                            <form:input path="username"  id="username" />
                            <form:errors path="username" class="error-label" />

                        </td>
                        </spring:bind>

                    </tr>

                    <tr>

                        <td>

                            <form:label path="password">Password:</form:label>

                        </td>

                        <td>

                            <form:password path="password" name="password" id="password" />
                            <form:errors path="password" class="error-label" />

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

                        <td><a href="home">Home</a>

                        </td>

                    </tr>

                </table>
                <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

            </form:form>

            <table align="center">

                <tr>

                    <td style="font-style: italic; color: red;">${message}</td>

                </tr>

            </table>

        </body>

        </html>
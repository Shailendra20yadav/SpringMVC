<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title>Welcome</title>
        
        <script>
	        function logoutFormSubmit() {
	            document.getElementById("logoutForm").submit();
	        }
	    </script>

    </head>

    <body>
    <div class="logout">
    <c:url var="logoutUrl" value="/perform-logout" />        
 
    <form action="${logoutUrl}" method="post" id="logoutForm">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
    <span >  <a href="javascript:logoutFormSubmit()"> Logout</a></span>
    
    </div>

        <table>

            <tr>

                <td>Welcome ${emp.firstName}</td>

            </tr>

            <tr>

            </tr>

            <tr>

            </tr>

            <tr>

                <td><a href="home">Home</a>

                </td>

            </tr>
            
            <tr>

                <td><a href="viewAllEmp">Show All Employees</a>
                <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

                </td>

            </tr>

        </table>

    </body>

    </html>
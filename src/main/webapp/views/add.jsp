<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Simple Spring Boot Application</title>
<body>
<h2>Simple Employees REST Service</h2>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Add Employee</h3>
<form method="POST" name="add_employee"
      action="<%=request.getContextPath()%>/add/employee">
    First Name: <input name="firstName" value="${firstName}" type="text" /> <br /> <br />
    Last Name: <input name="lastName" value="${lastName}" type="text" />
    Departure ID: <input name="departmentId" value="${departmentId}" type="number" />
    Job Title: <input name="jobTitle" value="${jobTitle}" type="text" />
    Gender: <input name="gender" value="${gender}" type="text" />
    Date Of Birth: <input name="dateOfBirth" value="${dateOfBirth}" type="date" />
    <br /> <br />
    <input value="Add Employee" type="submit" />
</form>
</body>
</html>
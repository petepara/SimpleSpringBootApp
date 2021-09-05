<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Simple Spring Boot Application</title>
<body>
<h2>Simple Employees REST Service</h2>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Update Employee</h3>
<form method="POST" name="update_employee"
      action="<%=request.getContextPath()%>/update/employee">
    <input hidden="hidden" name="id" value="${id}" type="number" />
    First Name: <input name="firstName" value="${employee.firstName}" type="text" />
    Last Name: <input name="lastName" value="${employee.lastName}" type="text" />
    Departure ID: <input name="departmentId" value="${employee.departmentId}" type="number" />
    Job Title: <input name="jobTitle" value="${employee.jobTitle}" type="text" />
    Gender: <input name="gender" value="${employee.gender}" type="text" />
    Date Of Birth: <input name="dateOfBirth" value="${employee.dateOfBirth}" type="date" />
    <input value="Update Employee" type="submit" />
</form>
</body>
</html>
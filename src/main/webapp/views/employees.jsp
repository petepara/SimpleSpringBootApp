<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Simple Spring Boot Application</title>
<body>
<h2>Simple Employees REST Service</h2>
<a href="<%=request.getContextPath()%>/addEmployee">Add</a>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${employees != null}">
        <h3>List of Employees</h3>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Gender</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="e" items="${employees}">
                <tr>
                    <td>${e.employeeId}</td>
                    <td>${e.firstName}</td>
                    <td>${e.lastName}</td>
                    <td>${e.gender}</td>
                    <td><a
                            href="<%=request.getContextPath()%>/employee/${e.employeeId}">Details</a>
                        &nbsp;<a
                                href="<%=request.getContextPath()%>/update/employee/${e.employeeId}">Update</a>
                        &nbsp; <a
                                href="<%=request.getContextPath()%>/delete/employee/${e.employeeId}"
                                onclick="return confirm('Do you really want to delete?')">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No Employee found!
    </c:otherwise>
</c:choose>
</body>
</html>
<%@ include file="taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department</title>
</head>
<body>
	<form:form name='f' action="employee.htm"  method='POST' commandName="organization">
	          Organization Name: <c:out value="${organization.name}" /><br>
	          Select Employees you want for your new Departments.
	          Admin Departments:<br>
	              <c:forEach var="department" varStatus="statusDepartment" items="${organization.adminDepartmentList}">
			          ______Dept: <c:out value="${department.name}" /><br>
			          <div class="checkbox-list">
		          			<form:hidden path="adminDepartmentList[${statusDepartment.index}].name"  value="${department.name}" />
			          		<c:forEach var="employee" varStatus="statusEmployee" items="${department.employeeList}">
			                    <form:checkbox path="adminDepartmentList[${statusDepartment.index}].employeeList" value="${employee.firstName}"/> <c:out value="${employee.firstName}" /><br>
			          		</c:forEach>
			          </div>
	              </c:forEach>
	              
	            Employee Departments:<br>
	              <c:forEach var="department" varStatus="statusDepartment" items="${organization.employeeDepartmentList}">
			          ______Dept: <c:out value="${department.name}" /><br>
			          <div class="checkbox-list">
		          			<form:hidden path="employeeDepartmentList[${statusDepartment.index}].name" value="${department.name}" />
			          		<c:forEach var="employee" varStatus="statusEmployee" items="${department.employeeList}">
			          			<form:checkbox path="employeeDepartmentList[${statusDepartment.index}].employeeList" value="${employee.firstName}"/> <c:out value="${employee.firstName}" /><br>
			          		</c:forEach>
			          </div>
	              </c:forEach>  
	          
	                <button type="submit" class="btn btn-lg btn-primary btn-block">Next Step</button>
	</form:form>
</body>
</html>
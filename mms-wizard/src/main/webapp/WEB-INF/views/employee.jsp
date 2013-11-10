<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form name='f' action="department.htm"  method='POST' commandName="organization">
	          Organization Name:
	          <input type="text" name="name" >
	          Departments:<br> Select admin-departments you want.
	          <div class="checkbox-list">
	              <c:forEach var="i" varStatus="status" items="${adminDepartmentList}">
	                  
	                    <input type="checkbox" name="adminDepartmentList" value="${i.id}"> <c:out value="${i.name}" /><br>
	                  
	                </c:forEach>
	          </div>
	          Departments:<br> Select employee-departments you want.
	          <div class="checkbox-list">
	              <c:forEach var="i" varStatus="status" items="${employeeDepartmentList}">
	                  
	                    <input type="checkbox" name="employeeDepartmentList" value="${i.id}"> <c:out value="${i.name}" /><br>
	                  
	                </c:forEach>
	          </div>
	</form:form>
</body>
</html>
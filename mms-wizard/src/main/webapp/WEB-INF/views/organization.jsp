<%@ include file="taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organization</title>
</head>
<body>
	<form:form name='fs' action="department.htm"  method='POST' commandName="organization">
	          Organization Name:
	          <input type="text" name="name" >
	          <!-- ============================================================== -->
	          Departments:<br> Select admin-departments you want.
	          <div class="checkbox-list">
	          <%-- Size :<c:out value="${organization.adminDepartmentList.size}"/> --%>
	              <c:forEach var="i" varStatus="status" items="${organization.adminDepartmentList}">
	    				<input type="checkbox" name="adminDepartmentList" value="${i.name}"> <c:out value="${i.name}" /><br>
	                </c:forEach>
	          </div>
	          <!-- ============================================================== -->
	          Departments:<br> Select employee-departments you want.
	          <div class="checkbox-list">
	              <c:forEach var="i" varStatus="status" items="${organization.employeeDepartmentList}">            
	                    <input type="checkbox" name="employeeDepartmentList" value="${i.name}"> <c:out value="${i.name}" /><br>
	                </c:forEach>
	          </div>
	          <button type="submit" class="btn btn-lg btn-primary btn-block">Next Step</button>
	</form:form>
</body>
</html>
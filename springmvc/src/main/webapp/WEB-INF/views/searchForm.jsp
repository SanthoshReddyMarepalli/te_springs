<%@page import="com.te.springmvc.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <%String msg=(String)request.getAttribute("msg"); 
    EmployeeBean bean=(EmployeeBean) request.getAttribute("data");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Form
</title>
</head>
<body>
<%
if(msg!=null && !msg.isEmpty()){
%>

<%=msg %>
<%
}
%>

<form action="./search" method="get">
		<label>Emp_id</label> 
		<label>:</label> 
		<input type="number" name="id">
		<br>
		<input type="submit" value="search">
</form>
<%if(bean!=null){ %>
<h4>Name:</h4>
<%=bean.getEname() %>
<h4>DOB:</h4>
<%=bean.getDob() %>
<h4>ID:</h4>
<%=bean.getId() %>
<%} %>
</body>
</html>
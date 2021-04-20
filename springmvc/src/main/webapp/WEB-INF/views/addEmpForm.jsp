<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="header.jsp" %>
	<%String msg=(String)request.getAttribute("msg"); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add EMP</title>
</head>
<body>
<%
if(msg!=null && !msg.isEmpty()){
%>
<h1>
<%=msg %>
</h1>
<%
}
%>

<form action="./addEmp" method="get">
		<label>Emp_Id</label> 
		<label>:</label> <input type="text" name="id">
		<br>
		<label>Emp_Name</label> 
		<label>:</label> 
		<input type="text"name="ename"> 
	    <br> 
	    <label>Emp_Dob</label> 
	    <label>:</label>
		<input type="text" name="dob"> 
		<br> 
		<label>Emp_Pwd</label>
		<label>:</label> 
		<input type="text" name="pwd"> 
		<br>
		<input type="submit" value="add">
	</form>
	</body>
</html>
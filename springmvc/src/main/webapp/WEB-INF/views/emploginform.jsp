<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String msg=(String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp Login Form</title>
</head>
<body>
<h1>

<%
if(msg!=null && !msg.isEmpty()){
%>

<%=msg %>
<%
}
%>
</h1>

	<form action="./emplogin" method="post">

		<label>Emp_id</label>.
		<label>:</label>
		<input type="text" name="id">
		<br> 
		<label>Emp_pwd</label> 
		<label>:</label> 
		<input type="text"name="pwd">
		<br>
		<input type="submit" value="login">
			
	</form>


</body>
</html>
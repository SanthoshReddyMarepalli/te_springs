<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <%String msg=(String)request.getAttribute("msg"); 
     String errMsg=(String) request.getAttribute("errMsg");
    %>
    <%int id=(int) request.getAttribute("id");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
</head>
<body>
<%
if(msg!=null && !msg.isEmpty()){
%>

<h1 style="color: green"><%=msg %></h1>
<%
}
%>
<%
if(errMsg!=null && !errMsg.isEmpty()){
%>

<%=errMsg %>
<%
}
%>
<form action="./update" method="get">
		<label>Emp_id</label> <label><%=id %></label>
		<label>:</label> <input hidden="true" type="text" name="id" value="<%=id%>">
		<br>
		<label>Emp_name</label> 
		<label>:</label> 
		<input type="text"name="name"> 
	    <br> 
	    <label>Emp_dob</label> 
	    <label>:</label>
		<input type="text" name="dob"> 
		<br> 
		<label>Emp_pwd</label>
		<label>:</label> 
		<input type="text" name="pwd"> 
		<br>
		<input type="submit" value="update">
	</form>

</body>
</html>
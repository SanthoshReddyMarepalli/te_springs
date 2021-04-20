<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ include file="header.jsp" %>
   <%String msg=(String)request.getAttribute("msg"); 
    String errMsg=(String) request.getAttribute("errMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Form</title>
</head>
<body>
<%
if(msg!=null && !msg.isEmpty()){
%>

<%=msg %>
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


<form action="./delete" method="get">
		<label>Emp_id</label> 
		<label>:</label> <input type="number" name="id">
		<br>
		<input type="submit" value="delete">
</form>
</body>
</html>
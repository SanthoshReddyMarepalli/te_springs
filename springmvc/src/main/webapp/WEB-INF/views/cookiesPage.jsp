<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%String msg=(String)request.getAttribute("msg"); 
     String employee=(String) request.getAttribute("cookies");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookies</title>
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
if(employee!=null && !employee.isEmpty()){
%>

<h1 style="color: green">Employee Name:<%=employee %></h1>
<%
}
%>
<h3><a href="./createCookie">Create Cookies</a></h3>
<h3><a href="./showCookie">Show Cookies</a></h3>

</body>
</html>
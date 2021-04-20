<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg= (String) request.getAttribute("err");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErrorPage</title>

</head>
<body>

<%if(msg!=null && !msg.isEmpty()){ %>
<h1><%=msg %></h1>
<%} %>

</body>
</html>
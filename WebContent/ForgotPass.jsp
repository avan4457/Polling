<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="polling.Models.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset password | Polling</title>
</head>
<body>
<%
String email = (String)request.getAttribute("email");
%>

<form action="ResetPassServlet" method="post">
Your email: <input type="text" name="email"  value=<%=email %> readonly="readonly" /><br><br>
<input type="submit" name="submit" />
</form>

</body>
</html>


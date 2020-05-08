<%@page import="java.util.ArrayList"%>
<%@page import="polling.Models.Election" %>
<%@page import="polling.Services.ElectionServices"%>
<%@page import="polling.Services.IElectionServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Results | Polling</title>
</head>
<body>
<%
IElectionServices ie = new ElectionServices();
ArrayList<Election> eList = ie.getElectionsByClosingDate();
%>

<h2>Choose the election to generate results..</h2>
<form action="GenResultServlet" method="POST">
<%for(Election e:eList){ %>
<input type="radio" name="election" value=<%=e.getId() %> /><%=e.getName() %><br>
<%} %>
<input type="submit" name="submit" value="See Results" />
</form>
</body>
</html>
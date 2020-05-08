<%@page import="java.util.ArrayList"%>
<%@page import="polling.Services.ElectionServices"%>
<%@page import="polling.Services.IElectionServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results | Polling</title>
</head>
<body>
<% 
int elecId = Integer.parseInt(String.valueOf((request.getAttribute("id"))));

IElectionServices ie = new ElectionServices();
ArrayList<String> res = ie.genResults(elecId);
%>

<%
int count = 1;
for(String s:res){
%>

<%=count %> -> <%=s %> <br>

<%
count++;
}
%>
</body>
</html>
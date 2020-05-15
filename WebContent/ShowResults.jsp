<%@page import="java.util.ArrayList"%>
<%@page import="polling.Services.ElectionServices"%>
<%@page import="polling.Services.IElectionServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="ShowResultsStyles.css">
<title>Results | Polling</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary"> <a class="navbar-brand"
		href="#">Polling Lanka</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home
					<span class="sr-only"></span>
			</a></li>
			<li class="nav-item active"><a class="nav-link" href="Commissioner.jsp">Commissioner
					<span class="sr-only"></span>
			</a></li>			
		</ul>
	</div>
	</nav>
<% 
int elecId = Integer.parseInt(String.valueOf((request.getAttribute("id"))));

IElectionServices ie = new ElectionServices();
ArrayList<String> res = ie.genResults(elecId);
%>
<div class="container">
		<span>results of  Election ID <%=elecId %></span><br>	
<div class="details">
<%
int count = 1;
for(String s:res){
%>

<%=count %> -> <%=s %> <br>

<%
count++;
}
%>
</div>	
	</div>
</body>
</html>
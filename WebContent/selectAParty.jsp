<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="java.util.ArrayList"%>
    <!-- IT19390260 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="selectElectionStyle.css">
<title>Insert title here</title>
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
			<li class="nav-item active"><a class="nav-link" href="selectAParty.jsp">parties
					<span class="sr-only"></span>
			</a></li>			
		</ul>
	</div>
	</nav>
<section class="wave">
			
		 <% String Eid= (String) request.getAttribute("Eid"); %> 
			<%ArrayList<String> par = (ArrayList) request.getAttribute("party"); %>
			<% String Vid= (String) request.getAttribute("Vid"); %>
		<div class="container">
			<span>parties</span>
			</div><br><br><br>
		<form action="selectParliamentCandidateServlet" method="post" class="details">
  			<label>Choose a Party:</label>
  			<select  name="party">
  			<%for (String Party:par){ %>
    			<option imagesrc="images/<%=Party%>.png" width="20px" height="20px" imagePosition="left"><%=Party%></option>
    			<%} %>
  			</select>
  			 <input type="hidden"  name="Eid" value="<%=Eid %>"> 
  			<input type="hidden"  name="Vid" value="<%=Vid %>">
  			<input type="submit" name="submit" class="btn btn-primary"  value="submit">
  			</form>

</body>
</html>
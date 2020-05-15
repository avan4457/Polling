<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page import="polling.Models.Voter" %>
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
 <link rel="stylesheet" href="deleteAccountStyle.css">
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
			<li class="nav-item active"><a class="nav-link" href="deleteAccount.jsp">Delete Account
					<span class="sr-only"></span>
			</a></li>			
		</ul>
	</div>
	</nav>
   <section class="wave">
   <%
Voter voter = (Voter) request.getAttribute("voter");
	%>  
	<div class="container">
<span>Voter Account delete</span>
</div>
	<!-- <h1>Voter Account delete</h1> -->
	<form action="deleteVoterAccountServlet" method="POST" id="form3">
	District<input class="form-control"type="text" name="district" class="form-control" value="<%=voter.getDistrict() %>" readonly/><br><br>  <!-- u.getId() --> 
	Status<input type="text" name="Status" class="form-control" value="<%=voter.getStatus()%>"  readonly/><br><br> 
	<input type="hidden" name="Vid" value= "<%=voter.getId() %>"  readonly/>
	<input type="submit" name="submit" class="btn btn-primary" value="delete My Voter Account" />
</form>
</body>
</html>
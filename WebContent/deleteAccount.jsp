<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page import="polling.Models.Voter" %>
 <!-- IT19390260 -->  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="deleteAccountStyle.css">
<title>Insert title here</title>
</head>
<body>
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
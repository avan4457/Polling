<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ page import="polling.Models.Voter" %> 
    <%@ page import="polling.Models.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="voterProfileStyle.css" >
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
			<li class="nav-item active"><a class="nav-link" href="voterProfile.jsp">Voter Profile
					<span class="sr-only"></span>
			</a></li>			
		</ul>
	</div>
	</nav>
<section class="wave">
 <div class="container">
<span>voter profile</span>
</div>

  	 	 <%
	User user = (User)request.getAttribute("user");
%>      


<%
Voter voter = (Voter) request.getAttribute("voter");
	%>
	<div class="box">
	<div class="imgBx">
	<img id="ima1" src="images/<%=user.getPic()%>" width="200" height="200" alt="Profile picture" class="border border-primary">
	</div>
	<div id="content">
		<table >
			<tr id="text">
					<td><i class="fa fa-star info"></i>NAME </td>
					<td><%=user.getName() %></td>
					
			</tr>
			
			<tr id="text">
					<td><i class="fa fa-star info"></i>  ID</td>
					<td><%=user.getId() %></td>  <%-- <%=voter.getId() %> --%>
					
			</tr>
			
			 <tr id="text">
					<td><i class="fa fa-star info"></i>  DISTRICT</td>
					<td><%=voter.getDistrict() %></td>
					
			</tr> 
			</section>
			
			<tr id="text">
					<td><i class="fa fa-envelope info" ></i>  EMAIL</td>
					<td><%=user.getEmail() %></td>
					
			</tr>
			
			 <tr id="text">
					<td><i class="fa fa-star info"></i>  STATUS</td>
					<td><%=voter.getStatus() %></td>
					
			</tr> 
			
			<tr id="text">
					<td><i class="fa fa-key info" ></i>  password</td>
					<td><%=user.getPassword()%></td>
					
			</tr>
			
			<tr id="text">
					<td><i class="fa fa-phone info"></i>  PhoneNumber</td>
					<td>  <%=user.getPhoneNumber() %></td>
					
			</tr>
			
			<tr id="text">
					<td><i class="fa fa-id-card info" ></i>  NIC</td>
					<td><%=user.getNic() %></td>
					
			</tr>
			
			<tr id="text">
					<td><i class="fa fa-star info"></i>  GENDER</td>
					<td><%=user.getGender() %></td>
					
			</tr>
		</table>
		
		
		<form  method="post" action="updateServlets" id="form2">
			<input type="hidden" name="Vid" value="<%=user.getId()%>" >
			<input type="submit" class="btn btn-primary" value="Update details">
		</form>
		<form method="post" action="displyElectionsServlet" id="form2">
			<input type="hidden" name="Vid" value="<%=user.getId()%>" >
			<input type="submit" class="btn btn-primary" value="Vote for Election">
		</form>
		<form  method="post" action="deleteVoterServlet" id="form2">
			<input type="hidden" name="Vid" value="<%=user.getId()%>" >
			<input type="submit" class="btn btn-primary" value="delete my voter Account">
		</form>
	</div>
	</div>	
</body>
</html>

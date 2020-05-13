<%@ page import="polling.Models.Election"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="polling.Services.ElectionServicesImp"%>
<%@ page import="polling.Services.IElectionServices"%>

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
<title>Election List</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2 class="display-4">
				<center>ELECTION LIST</center>
			</h2>
		</div>
	</div>
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
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link" href="Commissioner.jsp">Commissioner
					<span class="sr-only">(current)</span>
			</a></li>
			
		</ul>
	</div>
	</nav>
	<br>


	<table class="table table-hover table-dark">

		<tr>
			<th scope="col">Election ID</th>
			<th scope="col">Election Name</th>
			<th scope="col">Election Type</th>
			<th scope="col">Election Start date</th>
			<th scope="col">Election End date</th>
		</tr>
		<%
			IElectionServices iElectionServices = new ElectionServicesImp();
			ArrayList<Election> arrayList = iElectionServices.getElection();

			for (Election election : arrayList) {
		%>

		<tr>
			<td><%=election.getElectionID()%></td>
			<td><%=election.getElectionName()%></td>
			<td><%=election.getElectionType()%></td>
			<td><%=election.getStartDate()%></td>
			<td><%=election.getEndDate()%></td>
			<td>
				<form method="POST" action="ValidateVoterServlet">
					<input type="hidden" name="electionID"
						value="<%=election.getElectionID()%>" /> <input type="submit"
						value="Select Election" class="btn btn-light" />
				</form>
			</td>
		</tr>

		<%
			}
		%>
	</table>
</body>
</html>
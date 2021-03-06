<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="polling.Models.Election"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Election Ready</title>
</head>
<body>
	<!--  -->
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2 class="display-4">
				<center>CREATE AN ELECTION!!!</center>
			</h2>
		</div>
	</div>
	<%
		Election election = (Election) request.getAttribute("election");
	%>
	<%
		String prin = "";

		prin = (String) request.getAttribute("msg1");

		if (prin == null)
			prin = "WELCOME!!";
	%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary"> <a
		class="navbar-brand" href="#">Polling Lanka</a>
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
			<li class="nav-item active"><a class="nav-link"
				href="Commissioner.jsp">Commissioner <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="">Election List<span class="sr-only"></span>
			</a></li>

		</ul>
	</div>
	</nav>
	<br>
	<h4>
		<center><%=prin%></center>
	</h4>

	<form method="post" action="UpdateElectionServlet"
		class="text-center border border-light p-5">
		<div class="container" align="center">
			<table>
				<div class="form-group">
					<tr>

						<td>Election ID:</td>
						<td><input type="text" name="eleID" disabled="disabled"
							value="<%=election.getElectionID()%>" class="form-control" /></td>

					</tr>
				</div>
				<tr>
					<div class="form-group">
						<td>Election Name:</td>
						<td><input type="text" name="eleName"
							value="<%=election.getElectionName()%>" class="form-control" /></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td>Election Type:</td>
						<td><select name="eleType" class="form-control">
								<option value="President" checked="checked">Presidential</option>
								<option value="Parliament">Parliament</option>
								<option value="Provincial">Provincial</option>
						</select></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td>Election Starting Date:</td>
						<td><input type="date" id="startDate" name="startDate"
							value="<%=election.getStartDate()%>" class="form-control"></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td>Election Ending Date:</td>
						<td><input type="date" id="endDate" name="endDate"
							value="<%=election.getEndDate()%>" class="form-control"></td>
					</div>
				</tr>
				<tr>
					<td><input type="hidden" name="electionID"
						value="<%=election.getElectionID()%>" /><input type="submit"
						value="Update Election" class="btn btn-info btn-block my-4"></td>
				</tr>
			</table>
	</form>
	<form method="POST" action="DeleteElectionServlet">
		<table>
			<tr>
				<td><input type="hidden" name="electionID"
					value="<%=election.getElectionID()%>"><input type="submit"
					value="Delete Election" class="btn btn-info btn-block my-4"></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
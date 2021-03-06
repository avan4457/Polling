<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="polling.Models.Election"%>
<%@page import="polling.Services.ElectionServices"%>
<%@page import="polling.Services.IElectionServices"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Election.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Commissioner | Polling</title>
</head>
<body>
	<%
		IElectionServices ie = new ElectionServices();
		ArrayList<Election> eList = ie.getElectionsByClosingDate();
	%>

	<%
		String res = "";
		res = (String) request.getAttribute("msg");
		if (res == null)
			res = "WELCOME!!";
	%>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2 class="display-4">
				<center>CREATE AN ELECTION!!!</center>
			</h2>
		</div>
	</div>

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
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="Commissioner.jsp">Commissioner <span class="sr-only">(current)</span>
			</a></li>
			


		</ul>
	</div>
	</nav>
	<div class="container" align="center">
		<form method="post" action="AddElectionServlet">
			<p>
			<h4>
				<%=res%></h4>
			<br />
			<table>
				<tr>
					<div class="form-group">
						<td>Election Name:</td>
						<td><input type="text" name="eleName" class="form-control"></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td>Election Type:</td>
						<td><select name="eleType" class="form-control">
								<option value="President">Presidential </option>
								<option value="Parliament">Parliament </option>
								<option value="Provincial">Provincial</option>
						</select></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td>Election Starting Date:</td>
						<td><input type="date" id="startDate" name="startDate"
							class="form-control"></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td>Election Ending Date:</td>
						<td><input type="date" id="endDate" name="endDate"
							class="form-control"></td>
					</div>
				</tr>
				<tr>
					<div class="form-group">
						<td><input type="submit" value="Create Election"
							class="btn btn-primary"></td>
					</div>
				</tr>

				<tr></tr>
				<tr>
					<div class="form-group">
						<td><input type="reset" value="Reset All"
							class="btn btn-primary"></td>
					</div>
				</tr>
			</table>

		</form>

		<form method="post" action="ElectionListServlet">
			<table>
				<div class="form-group">
					<tr>
						<td><input type="submit" value="View Election List"
							class="btn btn-primary"></td>
					</tr>
				</div>
			</table>
		</form>

	</div>

	<form method="post" action="GetVotersServlet">
		<table>
			<div class="form-group">
				<tr>
					<td><input type="submit" value="Validate Voters"
						class="btn btn-primary position-absolute mid-left mid-center"></td>
				</tr>
			</div>
		</table>
	</form>
	<form method="post" action="GetCandidatesServlet">
		<table>
			<div class="form-group">
				<tr>
					<td><input type="submit" value="Validate Candidiates"
						class="btn btn-primary position-absolute mid-lefttwo mid-center"></td>
				</tr>
			</div>
		</table>
	</form>


<div class="container" align = "center" style="margin-bottom: 10px">
	 <h4 class="mb-3">Choose the election to generate results..</h4>
	<form action="GenResultServlet" method="POST">
		<%
			for (Election e : eList) {
		%>
		<div class="form-check">
		<input type="radio" class="form-check-input" name="election"
			value=<%=e.getElectionID() %> /><%=e.getElectionName() %><br>
		</div>
		<%
			}
		%>
		<input type="submit" name="submit" value="See Results"
			class="btn btn-primary" />
	</form>
</div>

</body>
</html>
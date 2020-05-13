<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="polling.Services.IElectionServices"%>
<%@ page import="polling.Services.ElectionServicesImp"%>
<%@ page import="polling.Models.Candidate"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="polling.Models.User"%>
<%@ page import="polling.Services.IuserServices"%>
<%@ page import="polling.Services.UserServices"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validate Candidates | Polling</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2 class="display-4">
				<center>CANDIDATE LIST</center>
			</h2>
		</div>
	</div>


	<%
			IElectionServices icandidateList = new ElectionServicesImp();
			ArrayList<Candidate> arr = new ArrayList<Candidate>();
			
			if (arr.size() > 0) {
		%>

	<table class="table table-hover table-dark">
		<tr>
			<th scope="col">Candidate ID</th>
			<th scope="col">Election ID</th>
			<th scope="col">Candidate Name</th>
			<th scope="col">Candidate District</th>
			<th scope="col">Candidate Party</th>
			<th scope="col">State</th>
		</tr>
		<%
				for(Candidate candidate: arr){
					User user = new User();
					IuserServices iuser = new UserServices();
					user = iuser.getUserById(candidate.getId());
			%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=candidate.getElectionId()%></td>
			<td><%=user.getName()%></td>
			<td><%=candidate.getDistrict()%></td>
			<td><%=candidate.getParty()%></td>
			<td><%=candidate.getState()%></td>
			

			<td>
				<form method="POST" action="ValidateCandidateServlet">
					<input type="hidden" name="id" value="<%=candidate.getId()%>"><input
						type="submit" value="Validate" class="btn btn-light">
				</form>
			</td>
		</tr>
		<%
			}
			} else {
		%>
		<h2>No Voters to Validate</h2>
		<%
			}
		%>
	</table>

</body>
</html>
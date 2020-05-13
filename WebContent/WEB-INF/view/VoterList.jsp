<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="polling.Services.IElectionServices"%>
<%@ page import="polling.Services.ElectionServices"%>
<%@ page import="polling.Models.Voter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2 class="display-4">
				<center>VOTER LIST</center>
			</h2>
		</div>
	</div>

	<table class="table table-hover table-dark">

		<tr>
			<th scope="col">Voter ID</th>
			<th scope="col">Status</th>
			<th scope="col">District</th>

		</tr>

		<%
		IElectionServices ivoterList = new ElectionServices();
		ArrayList<Voter> arry = ivoterList.getVoterList();
		
		for(Voter voterLs : arry){
	%>
		<tr>
			<td><%=voterLs.getId()%></td>
			<td><%=voterLs.getStatus()%></td>
			<td><%=voterLs.getDistrict()%></td>
			<td>
				<form method="POST" action="ValidateVoterServlet">
					<input type="hidden" name="id" value="<%=voterLs.getId()%>"><input
						type="submit" value="Validate" class="btn btn-light">
				</form>
			</td>
		</tr>
		<%
		}
	%>
	</table>




</body>
</html>
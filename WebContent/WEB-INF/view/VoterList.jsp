<%@page import="polling.Services.ElectionServicesImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="polling.Services.IElectionServices"%>
<%@ page import="polling.Services.ElectionServices"%>
<%@ page import="polling.Models.Voter"%>
<%@ page import="polling.Models.User"%>
<%@ page import="polling.Services.IuserServices"%>
<%@ page import="polling.Services.UserServices"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>	Validate Voters | Polling</title>
</head>
<body>
<%
String res = (String)request.getAttribute("msg");
if(res == null)
	 res = "Validate voters here..";
%>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2 class="display-4">
				<center>VOTER LIST</center>
			</h2>
			<h3>
				<center><%=res %></center>
			</h3>
		</div>
	</div>


		<%
		IElectionServices ivoterList = new ElectionServicesImp();
		ArrayList<Voter> arry = ivoterList.getVoterList();
		
		if(arry.size() > 0){%>
			<table class="table table-hover table-dark">

		<tr>
			<th scope="col">Voter ID</th>
			<th scope="col">Voter Name</th> 
			<th scope="col">District</th>
			<th scope="col">Phone</th>
			<th scope="col">Status</th>

		</tr>
		<%
		for(Voter voterLs : arry){
			User u = new User();
			IuserServices iu = new UserServices();
			u = iu.getUserById(voterLs.getId());
	%>
		<tr>
			<td><%=u.getNic() %></td>
			<td><%=u.getName() %></td>
			<td><%=voterLs.getDistrict()%></td>
			<td><%=u.getPhoneNumber()%></td>
			<td><%=voterLs.getStatus()%></td>
			
			<td>
				<form method="POST" action="ValidateVoterServlet">
					<input type="hidden" name="id" value="<%=voterLs.getId()%>"><input
						type="submit" value="Validate" class="btn btn-light">
				</form>
			</td>
		</tr>
		<%
		}}
		else{
	%>
	<h2>No Voters to Validate</h2>
	<%} %>
	</table>




</body>
</html>
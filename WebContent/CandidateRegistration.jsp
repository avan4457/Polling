<%@page import="polling.Models.Election"%>
<%@page import="java.util.List"%>
<%@page import="polling.Services.CandidateService"%>
<%@page import="polling.Services.ICandidateService"%>
<%@page import = "polling.Models.User" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<title>Candidate Registration</title>
</head>
<body>
<%
User u = (User)request.getAttribute("user");
String userId = u.getId();
%>
	<div class="row">
    	<div class="col-sm">
        	<h1>Candidate Registration</h1>
    	</div>
	</div>
	<div class="row">
		<div class="col-sm">	
			<form action="AddCandidate" method="post">
				<table class="table table-hover">
					<tr>
						<td>Election Type </td>
						<td>
							<select id ="Type" name="etype" class="form-control" >
								<option value="Presidential">Presidential</option>
								<option value="Provincial">Provincial</option>
								<option value="Parliamentary">Parliamentary</option>
							</select>
							
						</td>
						
						<%
							 
							ICandidateService iCandidateService = new CandidateService();
							List<Election> electionName = iCandidateService.getElectionByType();
							request.setAttribute("electionName", electionName);
						%>
					<tr>
						<td>Election</td>
						
						<td>
							<select name="election" class="form-control">
								<% for(Election e : electionName){ %>
    								<option>
        								<%=e.getElectionName() %>
    								</option>
  								<% } %>
  							</select>
						</td>
					</tr>
					<tr>
						<td>Political Party</td>
						<td><input type="text" name = "party" class="form-control"></td>
					</tr>
					<tr>
						<td>District</td>
						<td>
							<select name="district" class="form-control">
								<option>Ampara</option>
								<option>Anuradhapura</option>
								<option>Badulla</option>
								<option>Batticola</option>
								<option>Colombo</option>
								<option>Galle</option>
								<option>Gampaha</option>
								<option>Hambantota</option>
								<option>Jaffna</option>
								<option>Kaluthara</option>
								<option>Kandy</option>
								<option>Kegalle</option>
								<option>Kilinochchi</option>
								<option>Kurunegala</option>
								<option>Mannar</option>
								<option>Matale</option>
								<option>Matara</option>
								<option>Monaragala</option>
								<option>Mullativu</option>
								<option>Nuwaraeliya</option>
								<option>Polonnaruwa</option>
								<option>Puttalam</option>
								<option>Ratnapura</option>
								<option>Trincomalee</option>
								<option>Vavuniya</option>
							</select>
						</td>
					</tr>
					<tr>
					<input type="hidden" value=<%=userId %> name="uid">
						<td></td>
						<td>
							<button id ="buttonclick" type="submit" class="btn btn-primary">
                    		<span class="glyphicon glyphicon-plus"></span> Register
                			</button>
                		</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
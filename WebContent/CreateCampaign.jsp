<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

	<%
		String candidateId = request.getParameter("uid");
		int electionId =Integer.parseInt(request.getParameter("eid")) ;
	%>

	<div class = "container">
	<div class = "row">
		<div class="col-sm">
			<h2>Create Campaign</h2>
		</div>
	</div>
	
	<div class ="row">
		<div class="col-sm">
		<form action="AddCampaign" method="post">
		<input type="hidden" name="uid" value=<%=candidateId %> />
		<input type="hidden" name="eid" value=<%=electionId %> />
			<table class ="table">
				<tr>
					<td>Heading</td><td><input type="text" name="heading"></td>
				</tr>
				<tr>
					<td>Statement</td><td><input type="text" name="statement"></td></tr>
				<tr>
					<td>Description</td><td><input type="text" name="desc"></td></tr>
				<tr>
					<td><input type="submit" name="create" value ="Create"></td>
				</tr>
			</table>
		</form>
		</div>
	</div>	
		</div>
</body>
</html>
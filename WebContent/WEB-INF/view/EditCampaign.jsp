<%@page import="polling.Models.Campaign"%>
<%@page import="java.util.List"%>
<%@page import="polling.Services.CampaignService"%>
<%@page import="polling.Services.ICampaignService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class = "container">
	<div class = "row">
		<div class="col-sm">
			<h1>Edit Campaign</h2>
		</div>
	</div>
	
	<%
		String campaignId = request.getParameter("cid");
		String candidateId = request.getParameter("uid");
		int electionId = Integer.parseInt(request.getParameter("eid"));
		ICampaignService iCampaignService = new CampaignService();
		List<Campaign> camDetails1 = iCampaignService.getCampaign(campaignId, candidateId, electionId);
		String[] details = new String[3];
		details = iCampaignService.getListElements(camDetails1);
		
		String heading = details[0];
		String statement = details[1];
		String description = details[2];
	 %>
	
	<div class ="row">
		<div class="col-sm">
		<form action="UpdateCampaign" method="post">
			<table class ="table table hover">
				<tr>
					<td>Heading</td>
					<td><input type="text" name="heading" value ="<%=heading%>"></td>
				</tr>
				<tr>
					<td>Statement</td>
					<td><input type="text" name="statement" value="<%=statement %>"></td></tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="desc" value ="<%=description%>"></td></tr>
				<tr>
					<td><input type="submit" name="update" value ="Update"></td>
					
				</tr>
			</table>
		</form>
					<input type="hidden" name="cid" value ="<%=campaignId %>>">
					<input type="hidden" name="uid" value ="<%=candidateId %>>">
					<input type="hidden" name="eid" value ="<%=electionId %>>">
		</div>
	</div>	
		</div>
</body>
</html>
<%@page import="polling.Models.Campaign"%>
<%@page import="java.util.List"%>
<%@page import="polling.Services.CampaignService"%>
<%@page import="polling.Services.ICampaignService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class = "container">
	<div class = "row">
		<div class="col-sm">
			<h2>Create Campaign</h2>
		</div>
	</div>
	
	<%
		String campaignId = request.getParameter("cid");
		String candidateId = request.getParameter("uid");
		int electionId = Integer.parseInt(request.getParameter("eid"));
		String elecId = request.getParameter("eid");
		ICampaignService iCampaignService = new CampaignService();
		List<Campaign> camDetails1 = iCampaignService.getCampaign(campaignId, candidateId, electionId);
		String[] details = iCampaignService.getListElements(camDetails1);
		
		String heading = details[0];
		String statement = details[1];
		String description = details[2];
	 %>
	
	<div class ="row">
		<div class="col-sm">
		<form action="UpdateCampaign" method="post">
			<table class ="table">
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
					<input type="hidden" name="cid" value =<%=campaignId %> />
					<input type="hidden" name="uid" value =<%=candidateId %> />
					<input type="hidden" name="eid" value =<%=elecId %> />
		</form>
	
		</div>
	</div>	
		</div>
</body>
</html>
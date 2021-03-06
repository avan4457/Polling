<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import = "polling.Models.User" %>
<%@ page import = "polling.Models.Campaign" %>
<%@ page import = "java.util.List"%>
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
User u = (User)request.getAttribute("user");
String userId = u.getId();
%>
	<div class = "container">
		<div class = "row">
			<div class = "col-sm">
				<h2>Candidate Profile</h2>
			</div>	
		</div>
		<div class = "row">
			<div class = "col-sm">
				<table class="table table-hover">
					<c:forEach var = "can" items ="${candidateDetails}">
					

					<c:set var="uid" value="${can.candidateId}" />
					<c:set var="eid" value="${can.electionId}" />
					<c:set var="etype" value="${can.electionType}" />
					<c:set var="election" value="${can.election}" />
					<c:set var="party" value="${can.party}" />
					<c:set var="num" value="${can.number}" />
					<c:set var="district" value="${can.district}" />
					<c:set var="state" value="${can.state}" />
					
					<tr>
						<td>Election Type </td>
						<td>${can.electionType}</td>
					</tr>
					<tr>
						<td>Election</td>
						<td>${can.election}</td>
					</tr>
					<tr>
						<td>Political Party</td>
						<td>${can.party}</td>
					</tr>
					
					<tr>
						<td>Candidate Number</td>
						<td>${can.number}</td>
					</tr>
					
					<tr>
						<td>District</td>
						<td>${can.district}</td>
					</tr>
					
					<tr>
						<td>State</td>
						<td>${can.state}</td>
					</tr>
						<input type="hidden" name="uId" value="${can.candidateId}"><br>
						<input type="hidden" name="eId" value="${can.electionId}">
					</c:forEach>
					
	<%
	
	List<Campaign> camDetails = (List)request.getAttribute("camDetails");
	String type="button";
	if(camDetails == null){
		type="hidden";
	}
	
	%>
					<c:forEach var="cam" items="${camDetails}">
					
						<c:set var="cid" value="${cam.campaignId}" />
					
						<input type="hidden" name="cId" value="${cam.campaignId}">
					</c:forEach>
				</table>
			</div>
			
			<c:url value="CreateCampaign.jsp" var="createCampaign">
				<c:param name="uid" value="${uid}"/>
				<c:param name="eid" value="${eid}"/>
				<c:param name="etype" value="${etype}"/>
				<c:param name="election" value="${election}"/>
				<c:param name="party" value="${party}"/>
				<c:param name="num" value="${num}"/>
				<c:param name="district" value="${district}"/>
				<c:param name="state" value="${state}"/>
			</c:url>
			
			<c:url value="GetCampaign" var="viewCampaign">
				<c:param name="cid" value="${cid}"/>
				<c:param name="uid" value="${uid}"/>
				<c:param name="eid" value="${eid}"/>
				
			</c:url>
			
			<c:url value="EditCampaign.jsp" var="editCampaign">
				<c:param name="cid" value="${cid}"/>
				<c:param name="uid" value="${uid}"/>
				<c:param name="eid" value="${eid}"/>
			</c:url>
			
			<c:url value="DeleteCampaign" var="deleteCampaign">
				<c:param name="cid" value="${cid}"/>
				<c:param name="uid" value="${uid}"/>
				<c:param name="eid" value="${eid}"/>
			</c:url>
			
			<div class = "col-sm">
				<a href="${createCampaign}">
				<input type="button" class="btn btn-primary" value="Create Campaign" >
				</a>	
				<br><br>
				
				<a href="${viewCampaign}">
				<input type="<%=type %>" class="btn btn-primary" value="View Campaign">
				</a>
				
				<a href="${editCampaign}">
				<input type="<%=type %>" class="btn btn-primary" value="Edit Campaign">
				</a>
				
				<a href="${deleteCampaign}">
				<input type="<%=type %>" class="btn btn-primary" value="Delete Campaign">
					<span class="glyphicon glyphicon-plus"></span>
				</a>	
				<br>
				<br>
			</div>	
		</div>
	</div>
	
	
</body>
</html>
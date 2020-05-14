<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@page import="java.util.ArrayList"%>
  <%@ page import="polling.Models.Candidate" %>
  <!-- IT19390260  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="editVoter.css">
 <link rel="stylesheet" href="CandidatelistStyle.css">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary"> <a class="navbar-brand"
		href="#">Polling Lanka</a>
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
			<li class="nav-item active"><a class="nav-link" href="Candidatelist.jsp">votes
					<span class="sr-only"></span>
			</a></li>			
		</ul>
	</div>
	</nav>

<section class="wave">
<% String Vid= (String) request.getAttribute("Vid"); %>
		 <% String Eid= (String) request.getAttribute("Eid"); %> 
		 <% String Election= (String) request.getAttribute("Election"); %>
		  <%ArrayList<Candidate> ca = (ArrayList) request.getAttribute("candidate"); %> 
		  <% String party= (String) request.getAttribute("party"); %>
<%
String topic = "";
topic = (String)request.getAttribute("topic");
String type="hidden";
String  cl="container";
String  al="overlay";
if(topic == null){
	topic = "chosen candidate";
	type = "submit";
	 cl="cont";
	  al="over";
}

%>
	 <div class="<%=cl%>">
	 <span><%=topic %></span>
	<form action="addParliamentResultServlet" method="post" class="details">
	<%for(Candidate candidate : ca){ %>
		 	<img src="images/<%=candidate.getParty() %>.png" width="70" height="70" alt="Party picture" ><br>
		 	 <%=candidate.getParty()%>
  			<input type="hidden" name="Cid" value="<%=candidate.getCandidateId()%>" readonly>
  			<%=candidate.getName()%>
  			<%} %><br>
			<input type="hidden" name="party" value="<%=party %>">
			 <input type="hidden" name="Eid" value="<%=Eid %>">
  			 <input type="hidden" name="Election" value="<%=Election %>">
  			 <input type="hidden" name="Vid" value="<%=Vid %>">
  			<input type="<%=type%>" name="submit"  class="btn btn-primary"  value="submit">
		</form> 
		<div class="<%=al%>"></div> 
		</div>
		
</body>
</html>
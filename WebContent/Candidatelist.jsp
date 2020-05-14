<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@page import="java.util.ArrayList"%>
  <%@ page import="polling.Models.Candidate" %>
  <!-- IT19390260  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="editVoter.css">
 <link rel="stylesheet" href="CandidatelistStyle.css">
<title>Insert title here</title>
</head>
<body>
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
		 	 <%=candidate.getNo()%>
  			<input type="hidden" name="Cid" value="<%=candidate.getId()%>" readonly>
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
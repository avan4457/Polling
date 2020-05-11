<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@page import="java.util.ArrayList"%>
  <%@ page import="polling.Models.Candidate" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String vid= (String) request.getAttribute("id"); %>
		 <% String Eid= (String) request.getAttribute("Eid"); %> 
		 <% String Election= (String) request.getAttribute("Election"); %>
		  <%ArrayList<Candidate> ca = (ArrayList) request.getAttribute("candidate"); %> 
		  <% String party= (String) request.getAttribute("party"); %>
<%
String re = "";
re = (String)request.getAttribute("re");
String ls="hidden";
if(re == null){
	re = "chosen candidate";
	ls = "submit";
}

%>
	
	<form action="addParliamentResultServlet" method="post">
	<h4><%=re %></h4>
	<%for(Candidate candidate : ca){ %>
		 	<img src="images/<%=candidate.getParty() %>.png" width="70" height="70" alt="Party picture" ><br>
		 	 <%=candidate.getNo()%>
  			<input type="hidden" name="Cid" value="<%=candidate.getId()%>" readonly>
  			<p><%=candidate.getName()%><p><br> 
  			<%} %>
			<input type="hidden" name="party" value="<%=party %>">
			 <input type="hidden" name="Eid" value="<%=Eid %>">
  			 <input type="hidden" name="Election" value="<%=Election %>">
  			 <input type="hidden" name="id" value="<%=vid %>">
  			<input type="<%=ls%>" name="submit" value="submit">
		</form> 
</body>
</html>
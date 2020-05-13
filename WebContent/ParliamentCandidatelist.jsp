<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@page import="java.util.ArrayList"%>
  <%@ page import="polling.Models.Candidate" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="editVoter.css">
<title>Insert title here</title>
</head>
<body>
		<% String Vid= (String) request.getAttribute("Vid"); %>
		<% String Eid= (String) request.getAttribute("Eid"); %>
		<% String party= (String) request.getAttribute("party"); %>
		<%ArrayList<Candidate> can = (ArrayList) request.getAttribute("candidate"); %>
		 <img src="images/<%=party %>.png" width="70" height="70" alt="Profile picture" ><br><br>
		 <form action="addPresidentResultServlet" method="post">
		 	<%for(Candidate candidate : can){ %>
		 	 <%=candidate.getNo()%>
  			<input type="radio" name="Cid" value="<%=candidate.getId()%>">
  			<label for="<%=candidate.getId()%>"><%=candidate.getName()%></label><br><br>
  			 
  			<%} %>
  			<input type="hidden" name="Election" value="Parliament">
  			<input type="hidden" name="party" value="<%=party %>">
  			 <input type="hidden" name="Eid" value="<%=Eid %>">
  			 <input type="hidden" name="Vid" value="<%=Vid %>">
  			<input type="submit" value="Submit" class="btn btn-primary"  value="Submit">
		</form> 
</body>
</html>
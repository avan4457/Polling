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
	<!-- <form action="/action_page.php">
  			<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
  			<label for="vehicle1"> I have a bike</label><br>
  			<input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
  			<label for="vehicle2"> I have a car</label><br>
  			<input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
  			<label for="vehicle3"> I have a boat</label><br><br>
  			<input type="submit" value="Submit">
		</form> 
		<h1>paarlimaent<h1> -->
		
		<%-- <%ArrayList<String> a = (ArrayList) request.getAttribute("a"); %>
		 <form action="/action_page.php">
		 	<%for (String b:a){ %>
  			<input type="radio" id="vehicle1" name="vehicle1" value="<%=b %>">
  			<imag href="<%=b %>" length="" width="">
  			<label for="vehicle1"><%=b %></label><br>
  			<%} %>
  			<input type="submit" value="Submit">
		</form> --%>
		<% String vid= (String) request.getAttribute("id"); %>
		<% String Eid= (String) request.getAttribute("Eid"); %>
		<% String party= (String) request.getAttribute("party"); %>
		<%ArrayList<Candidate> can = (ArrayList) request.getAttribute("candidate"); %>
		 <form action="addParliamentResultServlet" method="post">
		 	<%for(Candidate candidate : can){ %>
		 	
		 	<input> <%=candidate.getNo()%></input>
  			<input type="radio" name="Cid" value="<%=candidate.getId()%>">
  			<label for="<%=candidate.getId()%>"><%=candidate.getName()%></label><br>
  			
  			<%-- <label  ><%=candidate.getName()%></label>
			<select name="<%=candidate.getId()%>">
			  <option value=""></option>
			  <option value="x">x</option>  
			  
			</select><br><br><br> --%> 
  			<%} %>
  			<input type="hidden" name="Election" value="Parliament">
  			<input type="hidden" name="Eid" value="<%=party %>">
  			 <input type="hidden" name="Eid" value="<%=Eid %>">
  			 <input type="hidden" name="id" value="<%=vid %>">
  			<input type="submit" value="Submit">
		</form> 
</body>
</html>
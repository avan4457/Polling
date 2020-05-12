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
		<!-- <form action="/action_page.php"> -->
		
  			
  			<%-- <label for="vehicle1"> ${candi.name} </label><br>
  			<img src="${candi.party}.jpg" alt="Trulli" width="500" height="333">
  			<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"> --%>
			
			
			 
		
		<!-- <input type="submit" value="Submit">
		</form> -->

		<%-- <c:forEach var="candi" items="${candidate}">
		
			${candi.name}
			${candi.party}
			
		</c:forEach> --%>
		<% String vid= (String) request.getAttribute("id"); %>
		 <% String Eid= (String) request.getAttribute("Eid"); %> 
		<%ArrayList<Candidate> can = (ArrayList) request.getAttribute("candidate"); %>
		 <form action="addPresidentResultServlet" method="post">
		 	<%for(Candidate candidate : can){ %>
		 	<input type="hidden" name="party" value="<%=candidate.getParty()%>">
		 	 <img src="images/<%=candidate.getParty()%>.png" width="70" height="70" alt="Profile picture" >
  			 <%=candidate.getNo()%>
  			<input type="radio" name="Cid" value="<%=candidate.getId()%>">
  			<label for="<%=candidate.getId()%>"><%=candidate.getName()%></label><br>
  			
			  	<%-- <label for="cars" ><%=candidate.getName()%></label>
			<select name="<%=candidate.getId()%>">
			  <option value=""></option>
			  <option value="x">x</option>
			  <option value="1">1</option>
			  <option value="2">2</option> 
			  <option value="3">3</option>  
			  
			</select><br><br><br> --%> 
  			<%} %>
  			<input type="hidden" name="Election" value="President">
  			 <input type="hidden" name="Eid" value="<%=Eid %>"> 
  		   <input type="hidden" name="id" value="<%=vid %>">  
  			<input type="submit" value="Submit">
		</form> 
		
		
		
				<%-- <%ArrayList<String> arr = (ArrayList) request.getAttribute("arr"); %>
		<form action="select" method="post">
  			<label>Choose a Election:</label>
  			<select  name="Election">
  			
    			<option ></option>
    			
  			</select>
  			<input type="submit" name="submit" value="submit">
		 --%>
</body>
</html>
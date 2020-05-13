<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="deleteAccountStyle.css">
<title>Insert title here</title>
</head>
<body>
<section class="wave">
			
		 <% String Eid= (String) request.getAttribute("Eid"); %> 
			<%ArrayList<String> par = (ArrayList) request.getAttribute("party"); %>
			<% String Vid= (String) request.getAttribute("Vid"); %>
		<form action="selectParliamentCandidateServlet" method="post">
  			<label>Choose a Party:</label>
  			<select  name="party">
  			<%for (String Party:par){ %>
    			<option ><%=Party%></option>
    			<%} %>
  			</select>
  			 <input type="hidden"  name="Eid" value="<%=Eid %>"> 
  			<input type="hidden"  name="Vid" value="<%=Vid %>">
  			<input type="submit" name="submit" class="btn btn-primary"  value="submit">
  			</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			
		 <% String Eid= (String) request.getAttribute("Eid"); %> 
			<%ArrayList<String> par = (ArrayList) request.getAttribute("party"); %>
			<% String id= (String) request.getAttribute("id"); %>
		<form action="selectParliamentCandidateServlet" method="post">
  			<label>Choose a Party:</label>
  			<select  name="party">
  			<%for (String P:par){ %>
    			<option ><%=P%></option>
    			<!-- <imag href="" name=""> -->
    			<%} %>
  			</select>
  			 <input type="hidden"  name="Eid" value="<%=Eid %>"> 
  			<input type="hidden"  name="id" value="<%=id %>">
  			<input type="submit" name="submit" value="submit">
  			</form>

</body>
</html>
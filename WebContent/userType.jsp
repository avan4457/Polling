<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ page import="polling.Models.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%--  <%
	User u = (User)request.getAttribute("user");+
%> --%> 
<%-- 	<%
	User u = new User();
		u.setId("C012345667");
		u.setEmail("dilshan@gmilcom");
		u.setGender("male");
		u.setName("dilshan");
		u.setNic("981303016V");
		u.setPassword("dilshan123");
		u.setPhoneNumber("0718827789");
%> --%>    
	<form method="post" action="updateVoterDetailsServlet">  
		<input type="hidden" name="id" value="u49" >             
		<input type="submit" name="voter" value="I'am a voter">
		</form><br><br><br><br>
		
		<form method="post" action="gfdsfsd">	
		<input type="submit" name="candidate" value="I'am a candidate">
		</form>
	
	
</body>
</html>
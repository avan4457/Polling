<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="polling.Models.User" %>
 <%@ page import="polling.Models.Voter" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%
	User u = (User)request.getAttribute("user");
%>    
   <%
Voter vo = (Voter) request.getAttribute("voter");
	%>  
	<h1>Voter Account delete</h1>
	<form action="deleteVoterAccountServlet" method="POST">
	District<input type="text" name="district" value="<%=vo.getDistrict() %>" readonly/><br><br>  <!-- u.getId() --> 
	Status<input type="text" name="Status" value="<%=vo.getStatus()%>"  readonly/><br><br> 
	<input type="hidden" name="id" value= "<%=vo.getId() %>"  readonly/>
	<input type="submit" name="submit" value="delete My Voter Account" />
</form>
</body>
</html>
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
<%-- 		<%
	User u = (User)request.getAttribute("user");
%>  --%>
<%-- <%
	User u = new User();
%> --%>
<%-- <% String name= (String) request.getAttribute("name"); %> --%>
 <% String cid= (String) request.getAttribute("cid"); %>
<% String vid= (String) request.getAttribute("vid"); %> 
		
		<form action="profile" method="post">
			<h1>succesful</h1>
   
		</form>
</body>
</html>


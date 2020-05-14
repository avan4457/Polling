<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="polling.Models.Voter" %>
     <%@ page import="polling.Models.Election" %>
      <%@page import="java.util.ArrayList"%>
      <!-- IT19390260 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="selectElectionStyle.css">
<title>Insert title here</title>
</head>
<body>
<section class="wave">
 <%
Voter voter = (Voter) request.getAttribute("voter");
	%>
<% String topic = "";
topic = (String)request.getAttribute("topic");
if(topic == null)
	topic = "Choose a Election";
%>

				<%ArrayList<Election> elec = (ArrayList) request.getAttribute("election"); %>
		<div id="content">
		  <div class="container">
			<span>current Elections</span>
			<%=topic %>
			</div><br><br><br>
		<form action="selectElectionServlet" method="post" class="details">
  			<label >Choose a Election:</label>
  			<select  name="Election">

  			<%for (Election election:elec){ %>
    			<option  ><%=election.getElectionName() %></option>

    			<%} %>
  			</select>
  			<input type="hidden" name="Vid" value= "<%=voter.getId()%>">
  			<input type="submit" name="submit" class="btn btn-primary"  value="submit">
</form>
</div>
</body>
</html>
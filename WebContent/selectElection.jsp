<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="polling.Models.Voter" %>
     <%@ page import="polling.Models.Election" %>
      <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
Voter voter = (Voter) request.getAttribute("voter");
	%>
<% String res = "";
res = (String)request.getAttribute("topic");
if(res == null)
	res = "Choose a Election";
%>

				<%ArrayList<Election> arr = (ArrayList) request.getAttribute("election"); %>
		<form action="selectElectionServlet" method="post">
  			<p><%=res %></p><br><br>
  			<label >Choose a Election:</label>
  			<select  name="Election">
  			<%for (Election election:arr){ %>
    			<option  ><%=election.getElectionName() %></option><%-- value="<%=election.getName() %>" --%>
    			<%} %>
  			</select>
  			<!-- <input type="radio" id="male" name="gender" value="male">
  <label for="male">Male</label> -->
  			<%-- <input type="hidden" name="Eid" value= "<%=election.getId()%>"> --%>
  			<%-- <%String id = (String) request.getAttribute("id"); %>
  			<input type="hidden" name="id" value= "<%=id %>"> --%>
  			<input type="hidden" name="id" value= "<%=voter.getId()%>">
  			<input type="submit" name="submit" value="submit">
</form>
</body>
</html>
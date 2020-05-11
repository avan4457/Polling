<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ page import="polling.Models.Voter" %> 
    <%@ page import="polling.Models.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		
	<%-- <form>
		NAME       	<input text="file"  value=<%=v.getId() %>> 
		ID          <h6> <%=v.getId() %></h6>
		DISTRICT    <h6> <%=v.getDistrict() %><    /h6>
		EMAIL       <h6> <%=v.getId() %></h6>
		STATUS      <h6> <%=v.getStatus() %> <h6>
		password    <h6> <%=v.getPassword() %></h6>
		PhoneNumber <h6> <%=v.getPassword() %></h6>
		NIC			<h6> <%=v.getPassword() %></h6>
		GENDER		<h6> <%=v.getPassword() %></h6>
		<input text="" >
		<input type="submit" name="submit" value="Update">
		</form> --%>
  	 	 <%
	User u = (User)request.getAttribute("user");
%>      
		<%-- <% voter v = new voter(); %> --%>
		
<%-- 			<%ArrayList<String> arr = (ArrayList) request.getAttribute("arr"); %>
 --%> 		<%
 		/* IvoterServices iv = new VoterServices();
 		ArrayList<voter> aaa =iv.getVoterDetails(id); */
 		/*  ArrayList<voter> aaa = (ArrayList) request.getAttribute("aaa");  */
%> 
 <%--  <%
	User u = new User();
  u.setEmail("sandun@gmail.com");
  u.setGender("male");
  u.setId("c01234567");
  u.setName("kulaaa");
  u.setNic("9813030818");
  u.setPhoneNumber("0711111111");
 	
%> --%> 
<%
Voter vo = (Voter) request.getAttribute("voter");
	%>
		<table>
			<tr>
					<td>NAME </td>
					<td><%=u.getName() %></td>
					
			</tr>
			
			<tr>
					<td>ID </td>
					<td><%=u.getId() %></td>  <%-- <%=voter.getId() %> --%>
					
			</tr>
			
			 <tr>
					<td>DISTRICT</td>
					<td><%=vo.getDistrict() %></td>
					
			</tr> 
			
			<tr>
					<td>EMAIL</td>
					<td><%=u.getEmail() %></td>
					
			</tr>
			
			 <tr>
					<td>STATUS</td>
					<td><%=vo.getStatus() %></td>
					
			</tr> 
			
			<tr>
					<td>password</td>
					<td><%=u.getPassword()%></td>
					
			</tr>
			
			<tr>
					<td>PhoneNumber</td>
					<td><%=u.getPhoneNumber() %></td>
					
			</tr>
			
			<tr>
					<td>NIC	</td>
					<td><%=u.getNic() %></td>
					
			</tr>
			
			<tr>
					<td>GENDER	</td>
					<td><%=u.getGender() %></td>
					
			</tr>
		</table>
		<form method="post" action="updateServlets">
			<input type="hidden" name="id" value="<%=u.getId()%>" >
			<input type="submit" value="Update details">
		</form>
		<form method="post" action="displyElectionsServlet">
			<input type="hidden" name="id" value="<%=u.getId()%>" >
			<input type="submit" value="Vote for Election">
		</form>
		<form method="post" action="deleteVoterServlet">
			<input type="hidden" name="id" value="<%=u.getId()%>" >
			<input type="submit" value="delete my voter Account">
		</form>
		 <%-- <form>
			<input type="hidden" name="id" value=<%v.getId() %> >
			<input type="hidden" name="id" value=<%v.getId() %> >
			<input type="hidden" name="id" value=<%v.getDistrict() %> >
			<input type="hidden" name="id" value=<%v.getId() %> >
			<input type="hidden" name="id" value=<%v.getStatus() %> >
			<input type="hidden" name="id" value=<%v.getPassword() %> >
			<input type="hidden" name="id" value=<%v.getId() %> >
			<input type="hidden" name="id" value=<%v.getId() %> >
			<input type="submit" name="submit" value="Update">
		</form> --%> 
</body>
</html>

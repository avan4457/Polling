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
<%--  <%
	User u = new User();
  u.setEmail("sandun@gmail.com");
  u.setGender("male");
  u.setId("c01234567");
  u.setName("kulaaa");
  u.setNic("9813030818");
  u.setPhoneNumber("0711111111");
 	
%> --%> 
<%--  <% Voter v = new Voter(); %> --%> 
<form action="RegisterServlet" method="POST">
	District<input type="text" name="district" value= "<%=vo.getDistrict()%>" required/><br><br>  <!-- u.getId() --> 
	Status<input type="text" name="Status" value="Invalid"  readonly/><br><br>    <%--  <!--  <%=vo.getStatus() %>--> --%>
	<input type="hidden" name="id" value= "<%=u.getId() %>"  readonly/><br><br>      <!-- meka wenas wnawada -->
	Password<input type="password" name="password" value= "<%=u.getPassword() %>" readonly /><br><br>
	Name<input   type="text" name="name" value= "<%=u.getName() %>" readonly><br><br>
	Email<input type="text"  name="email" value= "<%=u.getEmail() %>" readonly><br><br>
	phoneNumber<input type="text"  name="phoneNumber" value="<%=u.getPhoneNumber() %>" readonly><br><br>
	NIC<input type="text"  name="nic" value= "<%=u.getNic() %>"  readonly><br><br>
	gender<input type="text" name="gender" value= "<%=u.getGender() %>"  readonly><br><br>
<input type="submit" name="submit" value="Register" />
</form>
</body>
</html>
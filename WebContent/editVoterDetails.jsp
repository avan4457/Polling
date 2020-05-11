<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="polling.Models.User" %>
 <%@ page import="polling.Models.Voter" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="editVoter.css">
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
<form action="RegisterServlet" method="POST" id="form1">
	District<input type="text" name="district" class="form-control" value="<%=vo.getDistrict() %>" required/><br><br>  <!-- u.getId() --> 
	Status<input type="text" name="Status" class="form-control"value="Invalid"  readonly/><br><br>    <%--  <!--  <%=vo.getStatus() %>--> --%>
	<input type="hidden" name="id" class="form-control"value= "<%=u.getId() %>"  readonly/><br><br>      <!-- meka wenas wnawada -->
	Password<input type="password" name="password" class="form-control"value= "<%=u.getPassword() %>" readonly /><br><br>
	Name<input   type="text" name="name" class="form-control"value= "<%=u.getName() %>" readonly><br><br>
	Email<input type="text"  name="email" class="form-control"value= "<%=u.getEmail() %>" readonly><br><br>
	phoneNumber<input type="text"  name="phoneNumber" class="form-control"value="<%=u.getPhoneNumber() %>" readonly><br><br>
	NIC<input type="text"  name="nic" class="form-control" value= "<%=u.getNic() %>"  readonly><br><br>
	gender<input type="text" name="gender" class="form-control" value= "<%=u.getGender() %>"  readonly><br><br>
<input type="submit" name="submit" class="btn btn-primary" value="Register" />
</form>
</body>
</html>
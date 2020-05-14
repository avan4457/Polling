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
	User user = (User)request.getAttribute("user");
%>    
   <%
Voter voter = (Voter) request.getAttribute("voter");
	%>  
 
<form action="RegisterServlet" method="POST" id="form1">
	District<input type="text" name="district" class="form-control" value="<%=voter.getDistrict() %>" required/><br><br>  
	Status<input type="text" name="Status" class="form-control"value="Invalid"  readonly/><br><br>    
	<input type="hidden" name="Vid" class="form-control"value= "<%=user.getId() %>"  readonly/><br><br>     
	Password<input type="password" name="password" class="form-control"value= "<%=user.getPassword() %>" readonly /><br><br>
	Name<input   type="text" name="name" class="form-control"value= "<%=user.getName() %>" readonly><br><br>
	Email<input type="text"  name="email" class="form-control"value= "<%=user.getEmail() %>" readonly><br><br>
	phoneNumber<input type="text"  name="phoneNumber" class="form-control"value="<%=user.getPhoneNumber() %>" readonly><br><br>
	NIC<input type="text"  name="nic" class="form-control" value= "<%=user.getNic() %>"  readonly><br><br>
	gender<input type="text" name="gender" class="form-control" value= "<%=user.getGender() %>"  readonly><br><br>
<input type="submit" name="submit" class="btn btn-primary" value="Register" />
</form>
</body>
</html>
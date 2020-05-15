<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="polling.Models.User" %>
 <%@ page import="polling.Models.Voter" %> 
<!-- IT19390260 --> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="editVoter.css">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary"> <a class="navbar-brand"
		href="#">Polling Lanka</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home
					<span class="sr-only"></span>
			</a></li>
			<li class="nav-item active"><a class="nav-link" href="voterProfile.jsp">Voter Profile
					<span class="sr-only"></span>
			</a></li>			
		</ul>
	</div>
	</nav>
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
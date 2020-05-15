<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String candidateId = request.getParameter("uid");
		int electionId =Integer.parseInt(request.getParameter("eid")) ;
	%>
	<div class= "container">
		<c:forEach var = "cam" items ="${camDetails}">
		
			
		
		<div class ="row">
			<div class="col-sm">
				<h1><b>${cam.heading}</b></h1>
			</div>
		</div>
		<div class ="row">
			<div class="col-sm">
				<h3>${cam.statement}</h3>
			</div>
		</div>
		<div class ="row">
			<div class="col-sm">
				<p>${cam.description}</p>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>
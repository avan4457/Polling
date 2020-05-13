<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>Candidate Registration</title>
</head>
<body>
	<div class="row">
    	<div class="col-sm">
        	<h1>Candidate Registration</h1>
    	</div>
	</div>
	<div class="row">
		<div class="col-sm">	
			<form action="AddCandidate" method="post">
				<table class="table table-hover">
					<tr>
						<td>Election Type </td>
						<td>
							<select name="etype" class="form-control">
								<option>Presidential</option>
								<option>Provincial</option>
								<option>Parliamentary</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Election</td>
						<td><input type="text" name="election" class ="form-control"></td>
					</tr>
					<tr>
						<td>Political Party</td>
						<td><input type="text" name = "party" class="form-control"></td>
					</tr>
					<tr>
						<td>District</td>
						<td>
							<select name="district" class="form-control">
								<option>Ampara</option>
								<option>Anuradhapura</option>
								<option>Badulla</option>
								<option>Batticola</option>
								<option>Colombo</option>
								<option>Galle</option>
								<option>Gampaha</option>
								<option>Hambantota</option>
								<option>Jaffna</option>
								<option>Kaluthara</option>
								<option>Kandy</option>
								<option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button id ="buttonclick" type="submit" class="btn btn-primary">
                    		<span class="glyphicon glyphicon-plus"></span> Register
                			</button>
                		</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
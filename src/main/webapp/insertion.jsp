<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertion</title>
 	<link rel="stylesheet" type="text/css" href="css/insert.css">
</head>
<body>
 	<jsp:include page="index.html"></jsp:include>
 	
 	<div class = "main-form">
 		<form action="homeSrv" method="post">
 			<input type="hidden" name="opr" value="insert">
 			<input type="number" name="id" placeholder="Enter ID"><br><br>
 			<input type="text" name="name" placeholder="Enter Name"><br><br>
 			<input type="text" name="city" placeholder="Enter City"><br><br>
 			<input type="number" name="salary" placeholder="Enter Salary"><br><br>
 			<input type="text" name="mobile" placeholder="Enter Mobile"><br><br>
 			
 			<button type="submit">Insert</button>
 		</form>
 	</div>
 	
</body>
</html>
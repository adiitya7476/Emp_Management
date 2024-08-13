<%@page import="com.emp.dao.SqlQueries"%>
<%@page import="com.emp.bean.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet" type="text/css" href="css/insert.css">

</head>
<body>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	Emp ob = SqlQueries.getIdData(id);
%>

<h2>Update Employee Details</h2>
<div class = "main-form">
	<form action="homeSrv" method="post">
		<input type="hidden" name = "opr" value="updateData">
		<input type="hidden" name = "id" value=<%=ob.getId() %>>
		<input type="text" name="name" value=<%=ob.getName() %>>
		<input type="text" name="city" value=<%=ob.getCity() %>>
		<input type="text" name="salary" value=<%=ob.getSal() %>>
		<input type="text" name="mobile" value=<%=ob.getMobile() %>>
		
		<button type="submit">Update</button>
		
	</form>
</div>
</body>
</html>
<%@page import="com.emp.dao.SqlQueries"%>
<%@page import="com.emp.bean.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet" type="text/css" href="css/dataFetch.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="index.html"></jsp:include>


	<%
	List<Emp> al = SqlQueries.dataFetch();
	%>
	
	<h2 style="color: blue;">Update Employee Details</h2>
	
	<div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>City</th>
                    <th>Salary</th>
                    <th>Mobile</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <% for(Emp ob : al) { %>
                <tr>
                    <td><%=ob.getId() %></td>
                    <td><%=ob.getName() %></td>
                    <td><%=ob.getCity() %></td>
                    <td><%=ob.getSal() %></td>
                    <td><%=ob.getMobile() %></td>
                    <td>
                    	<form action="homeSrv" method="post">
                    		<input type="hidden" name="opr" value="updateId">
                    		<input type="hidden" name="id" value=<%=ob.getId() %>>
                    		<input type="hidden" name="name" value=<%=ob.getName() %>>
                    		<input type="hidden" name="city" value=<%=ob.getCity() %>>
                    		<input type="hidden" name="salary" value=<%=ob.getSal() %>>
                    		<input type="hidden" name="id" value=<%=ob.getMobile() %>>
                    		
                    		<button type="submit" style="background-color: transparent;"><i class="fa fa-edit" style="font-size:24px; color: blue;"></i></button>
                    	</form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
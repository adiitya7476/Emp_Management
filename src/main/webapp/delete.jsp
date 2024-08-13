<%@page import="com.emp.dao.SqlQueries"%>
<%@page import="java.util.List"%>
<%@page import="com.emp.bean.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
<link rel="stylesheet" type="text/css" href="css/dataFetch.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="index.html"></jsp:include>


	<%
	List<Emp> al = SqlQueries.dataFetch();
	%>
	
	<h2 style="color: red;">Delete Employee Details</h2>
	
	<div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>City</th>
                    <th>Salary</th>
                    <th>Mobile</th>
                    <th>Delete</th>
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
                    		<input type="hidden" name="opr" value="deleteId">
                    		<input type="hidden" name="id" value=<%=ob.getId() %>>
                    		<button type="submit"><i class="fa fa-trash-o" style="font-size:24px;color:red;text-align: center;"></i></button>
                    	</form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
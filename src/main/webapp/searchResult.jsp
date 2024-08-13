<%@page import="com.emp.dao.SqlQueries"%>
<%@page import="com.emp.bean.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" type="text/css" href="css/dataFetch.css">
</head>
<body>
	<jsp:include page="index.html"></jsp:include>
	
	<h2 style="color: green;">Search Results</h2>
	<%
		String name = request.getParameter("name");
		List<Emp> al = SqlQueries.searchName(name);
	%>
	
	<div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>City</th>
                    <th>Salary</th>
                    <th>Mobile</th>
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
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
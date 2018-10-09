<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page import = "java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style>
	form{ display: inline; }
	
	.container{
		padding-top: 5vh;
	}
</style>
<title>Students</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<a href="/students/new" class="btn btn-sm btn-primary">Add a New Student</a>
			</div>
		</div>
		
		<br><br>
		<table class="table table-striped">
		    <thead class="thead-dark">
		        <tr>
		            <th>Name</th>
		            <th>Age</th>
		            <th>Address</th>
		            <th>City</th>
		            <th>State</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${students}" var="student">
		        <tr>
		            <td>${student.getFullName()}</td>
		            <td>${student.getAge()}</td>
		            <td>${student.getContact().getAddress()}</td>
		            <td>${student.getContact().getCity()}</td>
		            <td>${student.getContact().getState()}</td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>

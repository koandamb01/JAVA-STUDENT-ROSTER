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
</style>
<title>New Contact</title>
</head>
<body>
	<div class="container">
		<h1>New Contact</h1>
		<br><br>
		<div class="row">
			<div class="col-md-6">
				<form:form action="/contact/new" method="POST" modelAttribute="contact">
			    <div class="form-group">
			        <form:select path="student" class="form-control">
			        	<c:forEach var="student" items="${students}">
					        <form:option value="${student.id}"> ${student.getFullName()}</form:option>
					    </c:forEach>
			        </form:select>
			    </div>
			    
			    <div class="form-group">
			        <form:label path="address">Address: </form:label>
			        <form:errors path="address" class="text-danger"/>
			        <form:input path="address" class="form-control" type="text"/>
			    </div>
			    
			   <div class="form-group">
			        <form:label path="city">City: </form:label>
			        <form:errors path="city" class="text-danger"/>
			        <form:input path="city" class="form-control" type="text"/>
			   </div>   
			    
			    <div class="form-group">
			        <form:label path="state">State: </form:label>
			        <form:errors path="state" class="text-danger"/>
			        <form:input path="state" class="form-control" type="text"/>
			   </div>  
			   
			    <input type="submit" value="Create" class="btn btn-primary"/>
			</form:form>    
			</div>
		</div>
	</div>
</body>
</html>

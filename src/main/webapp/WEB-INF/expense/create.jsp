<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="test/css" href="/static/css/style.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Create Expense</title>
</head>
<body>
	<h1>Create an Expense</h1>
	<form:form action="/expenses/create" modelAttribute="expense" method="post">
	<form:input type="hidden" value="${user_id}" path="account" />
		<div class="form-group">
			<label>Expense Name: </label>
			<form:input type="text" path="name" class="form-control"/>
			<form:errors path="name" class="text-danger"/>
		</div>
		<div class="form-group">
			<label>Amount: </label>
			<form:input type="number" path="amount" class="form-control"/>
			<form:errors path="amount" class="text-danger"/>
		</div>
		<div class="form-group">
			<label>Type: </label>
			<form:select path="type" class="form-control">
				<form:option value="Want" />
				<form:option value="Need" />
				<form:option value="Luxury" />
			</form:select>
			<form:errors path="type" class="text-danger"/>
		</div>
		<div class="form-group">
			<label>Frequency: </label>
			<form:select path="freq" class="form-control">
				<form:option value="One-time"></form:option>
				<form:option value="Fixed"></form:option>
				<form:option value="Recurring"></form:option>
			</form:select>
			<form:errors path="freq" class="text-danger"/>
		</div>
		<br/>
		<input type="submit" value="Submit" class="btn btn-success"/>
		<a class="btn btn-secondary" href="/">Back</a>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="test/css" href="/static/css/style.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>View Expense</title>
</head>
<body>
	<h1><c:out value="${expense.name}"/></h1>
	<h3>Amount: ${amount}</h3>
	<h3>Type: <c:out value="${expense.type}"/></h3>
	<h3>Frequency: <c:out value="${expense.freq}"/></h3>
	<br/>
	<c:if test="${expense.account.id == user_id}">
		<a class="btn btn-warning" href="/expenses/edit/${expense.id}"> Edit </a>
	</c:if>
</body>
</html>
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
<title>Dashboard</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light justify-content-between">
		<h1 class="navbar-brand">Hello, <c:out value="${loggedInUser.userName}"/>!</h1>
		<a href="/users/logout" class="form-inline btn btn-info">Logout</a>
	</nav>
	<h1>Income: ${loggedInUser.income}</h1>
	<a href="#">Edit</a>
	<br/>
	<h1>Expenses: </h1>
	<br/>
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col"> Expense </th>
					<th scope="col"> Amount </th>
					<th scope="col"> Type </th>
					<th scope="col"> Frequency </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${allExpenses}">
					<c:if test="${expense.account.id == loggedInUser.id}">	
						<tr>
							<td><a href="/expenses/view/${expense.id}"><c:out value="${expense.name}"/></a></td>
							<td> ${expense.amount} </td>
							<td><c:out value="${expense.type}"/></td>
							<td><c:out value="${expense.freq}"/></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	<br/>
	<a href="/expenses/create" class="btn btn-primary">New Expense</a>
</body>
</html>
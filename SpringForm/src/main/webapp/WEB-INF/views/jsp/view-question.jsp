<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question List Manage</title>
</head>
<body>
	<h1>Question List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Question</th>
		</tr>
		<c:forEach var="ques" items="${list}">
			<tr>
				<td>${ques.id}</td>
				<td>${ques.question}</td>
				<td><a href="delete/${ques.question}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<form action="addnew" method="post">
		Question <input type="text" name="question"><br> <input
			type="submit" value="Add new">
	</form>
</body>
</html>
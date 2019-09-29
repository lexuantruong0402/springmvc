<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Spring MVC Form Handling</title>
</head>

<body>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Name</th>
			<th>Score</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.name}</td>
				<td>${emp.score}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

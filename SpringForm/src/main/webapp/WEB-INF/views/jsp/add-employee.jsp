<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
<h2>Admin Login</h2>
<form action="adminLogin" method="post">
	 <input type="password" name="pwd"><br> <input
			type="submit" value="Submit">
</form>
</head>

<body>
	<h2>Employee</h2>
	<form:form method="POST" action="addEmployee" modelAttribute="employee">
		Name: <form:input path="name" />
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>

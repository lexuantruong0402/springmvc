<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete the following paragraph exactly in the form </title>
</head>
<body>
	<a href="startGame">Start</a>
	<form action="addScore" method="post">
		${ques} <input type="text" name="answer"><br> <input
			type="submit" value="Submit">
	</form>
</body>
</html>
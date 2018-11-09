<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome dear user, here you can search any book you want in our database("Christine"" for example ...)</h1>
	<form method="post" action="/Mini-project/ResServlet">
		<input type="text" name="book" class="book">
		
		<input type="submit" value="Let's see what we've got !" class="submit"><br>
	</form>
	
	<form method="post" action="/Mini-project/AuthServlet">
		<input type="hidden" name="hidden" value="done">
		<input type="submit" value="Log out" name="logout">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<h1>We need you to identify</h1>
	<form method="post" action="/Mini-project/AuthServlet">
		<label for="login">Your login : (type "user01" for example)</label>
		<input type="text" class="formul" name="login"><br>
		<label for="mdp">Your password : (type "user01" for example)</label>
		<input type="text" class="formul" name="mdp"><br>
		
		<input type="submit" value="Log-in" id ="submit">
	</form>
</body>
</html>
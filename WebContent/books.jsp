<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import ="project.mvc.model.Reservation" %>
	
	<jsp:useBean id="books" beanName="request.getAttribute('books')" scope="request" type="project.mvc.model.Reservation"/>
	
	<h1>Livre trouv� : <jsp:getProperty property="bookName" name="books"/></h1> <br>
	
	<h2>You can either try to reserve this book ...</h2>
	<form method="post" action="/Mini-project/ResServlet">
		<label for="reserve">Reserve this book if it's available :</label>
		<input type="hidden" name="confirm" value="done">
		<input type="submit" value="Reserve" name="reserve">
	</form>
	
	<br>
	
	<h2>... or try to find another book !</h2>
	<form method="post" action="/Mini-project/ResServlet">
		<input type="text" name="book">
		<input type="submit" value="go">
	</form>
	<br>
	<form method="post" action="/Mini-project/AuthServlet">
		<input type="hidden" name="hidden" value="done">
		<input type="submit" value="Log out" name="logout">
	</form>
	
</body>
</html>
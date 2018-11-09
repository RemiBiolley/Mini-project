<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% HttpSession s = request.getSession(true);
	 	if(s.getAttribute("login")==null){
		response.sendRedirect( request.getContextPath() + "/index.jsp");	
	}
	%>
	
	<h1>Your reservation is complete !</h1>
	<form method="post" action="/Mini-project/AuthServlet">
		<input type="hidden" name="hidden" value="done">
	</form>
	
	<br>
	
	You definitely should try out another book (Harry Potter) !
	<form method="post" action="/Mini-project/ResServlet">
		<input type="text" name="book">
		<input type="submit" value="go"> 
		<br>
		<label for="logout">Or will you leave us ?</label>
		<input type="submit" value="Log out" name="logout">
	</form>
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import = "java.util.Objects" %>
	<% HttpSession s = request.getSession(true);
	 	if(s.getAttribute("login")==null){
		response.sendRedirect( request.getContextPath() + "/index.jsp");	
	}
	%>
	
	<% if(Objects.equals(request.getAttribute("confResult"), "success")) {%>
	<h1>Your reservation is complete !</h1>
	<% } else { %>
	<h1>It seems that this book has already been reserved ... You should try to come back later.</h1>
	<% } %>
	<br>
	
	You definitely should try out another book (Harry Potter) !
	<form method="post" action="/Mini-project/ResServlet">
		<input type="text" name="book">
		<input type="submit" value="go"> 
		<br>
	</form>
	
	<form method="post" action="/Mini-project/AuthServlet">
		<input type="hidden" name="hidden" value="done">
		<input type="submit" value="Log out" name="logout">
	</form>
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- redirect to the index if you didn't login first -->
	<% HttpSession s = request.getSession(true);
	 	if(s.getAttribute("login")==null){
		response.sendRedirect( request.getContextPath() + "/index.jsp");	
	}
	%>
	
	<!--  displays a message as you arrive on the page -->
	<% if(request.getAttribute("noBook")==null){ %>
	<h1>Welcome dear user, here you can search any book you want in our database("Christine"" for example ...)</h1>
	
	<!-- displays a message if you tried to find a book which isn't contained in the database -->
	<% } else {%>
	<h1>The book you are looking for isn't present in our library ...</h1>
	<% } %>
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
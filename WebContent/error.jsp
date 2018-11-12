<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error !</title>
</head>
<body>
	<!-- redirect to the index if you didn't login first -->
	<% HttpSession s = request.getSession(true);
	 	if(s.getAttribute("login")==null){
		response.sendRedirect( request.getContextPath() + "/index.jsp");	
	}
	%>
	
	<h1>You're facing a log-in error ...</h1>
	<p>You should check your logins and try again</p>
	
	<form method="post" action="index.jsp">
		<input type="submit" value="Go back to the identification page" name="submit">
	</form>
</body>
</html>
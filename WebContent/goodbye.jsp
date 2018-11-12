<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bye !</title>
</head>
<body>
	<!-- redirect to the index if you didn't login first -->
	<% HttpSession s = request.getSession(true);
	 	if(s.getAttribute("login")==null){
		response.sendRedirect( request.getContextPath() + "/index.jsp");	
	}
	%>
	<h1>See you soon !</h1>
</body>
</html>
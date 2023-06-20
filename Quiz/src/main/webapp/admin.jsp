<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
		<div>
		<h1>Welcome to Admin Login </h1>
		<form action="">
		Enter email id :<input type="email" name="email" required><br><br>
		Enter password :<input type="password" name="password" required><br><br>
		<input type="submit" value="login" name="admin" >
		</form>
	<%
		if(request.getParameter("admin")!=null){
			if(request.getParameter("email").equals("paul@gmail.com") && request.getParameter("password").equals("mugi")){
				response.sendRedirect("adminPage.jsp");
			}
			else{
				out.print("<h3 align='center'>Wrong Credentials.</h3>");
			}
		}
	%>
	</div>
</body>
</html>
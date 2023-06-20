<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
	
		<a href="adminPage.jsp">Go back</a>
		<h1>Add New User<br>Register</h1>
		<form action="">
			Enter user name : <input type="text" name="name" required><br><br>
			Enter email id : <input type="email" name="email" required><br><br>
			Enter password : <input type="password" name="password" required><br><br>
			<input type="submit" name="signup" value="add user"> 
		</form>
		<%
			if(request.getParameter("signup")!=null){
				User user=new User();
				UserMain usermain=new UserMain();
				user.name=request.getParameter("name");
				user.email=request.getParameter("email");
				user.password=request.getParameter("password");
				try{
					usermain.insertUser(user);
					out.print("<h3>User Details Added Successfully</h3>");
					
				}
				catch(Exception e){
					out.print("<h3>User Email id Already Exists</h3>");
				}
		
			}
		%>
	
</body>
</html>
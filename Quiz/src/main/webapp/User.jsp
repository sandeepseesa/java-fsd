<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Quiz Portal</title>
</head>
<body>
		<h1>Welcome to Quiz Portal...!<br>Register</h1>
		<form action="">
			Enter user name : <input type="text" name="name" required><br><br>
			Enter email id : <input type="email" name="email" required><br><br>
			Enter password : <input type="password" name="password" required><br><br>
			<input type="submit" name="signup" value="sign up"><br><br>
		</form>
		Already do you have an Account? <a href="login.jsp">Sign in</a>
		<%
			if(request.getParameter("signup")!=null){
				User user=new User();
				UserMain usermain=new UserMain();
				user.name=request.getParameter("name");
				user.email=request.getParameter("email");
				user.password=request.getParameter("password");
				try{
					usermain.insertUser(user);
					response.sendRedirect("register.jsp");
				}
				catch (Exception e){
					out.print("<h3>Email id is Already Exists</h3>");
				}
		
			}
		%>
</body>
</html>
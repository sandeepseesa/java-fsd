<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	
	<%out.println("Have a Great day" + new java.util.Date()); %>
	
	JSP Expressions Demo<br>
	
	<%= java.util.Calendar.getInstance().getTime() %><br>
	
	JSP Declaration Demo<br>
	<%! int data =100;
		public int somenumber(){
			return 150;
		}
	
	
	%>
	<%= "Value is: " + data %><br>
	<%= "Value is: " + somenumber()%>
</body>
</html>
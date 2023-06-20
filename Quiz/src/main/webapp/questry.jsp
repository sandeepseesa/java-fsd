<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz</title>
</head>
<body>	
		<a href="adminPage.jsp">Go back</a>
		<h1>QuestDetails</h1>
		<% 
			QuestionsOperations qu=new QuestionsOperations();
			List<Questions> list=qu.getQuestions();%>
			<table border="1">
					<tr><th>No.</th><th>Quiz Title</th><th>Category</th></tr>
			<% for(Questions a:list){%>			
				<tr><td><%=a.question %></td><td><%=a.option1 %></td><td><%=a.option2 %></td><td><%=a.option3 %></td><td><%=a.option4 %></td>
				<td><%=a.answer%></td>
				</tr>		
			<%}%>
			</table>
			
</body>
</html>
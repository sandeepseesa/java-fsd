<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
		<a href="adminPage.jsp">Go back</a>
		<h1>Questions Details</h1>
		<% 
		QuestionsOperations ques=new QuestionsOperations();
		 List<Questions> li=ques.getQuestions();%>
		 	<table border="1" cellpadding="5">
			<tr><th>Question</td><th>Option1</th><th>Option2</th><th>Option3</th><th>Option4</th><th>Answer</th></tr>	
			<% for(Questions a:li){%>
				
				<tr><td><%=a.question %></td><td><%=a.option1 %></td><td><%=a.option2 %></td><td><%=a.option3 %></td><td><%=a.option4 %></td>
				<td><%=a.answer%></td>
				</tr>		
			<%}%>
			</table>
			
</body>
</html>
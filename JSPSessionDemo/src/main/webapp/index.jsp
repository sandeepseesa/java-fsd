<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	if (request.getParameter("error") != null)
		out.println("<b>Your session has expired or is invalid userid or password.</b><br>");
	%>
	
    
    <form action="login.jsp" method="post">

		Name <input type="text" name="name" id="name" maxlength=40><br>
		Password <input type="password" name="pwd" id="pwd" maxlength="10"><br>

		<button>Submit</button>

	</form>
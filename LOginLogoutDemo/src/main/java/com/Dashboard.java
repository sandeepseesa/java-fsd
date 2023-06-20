package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import jakarta.servlet.http.HttpSession;

public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
	PrintWriter out = response.getWriter();
	response.setContentType("type/html");

	// getSession(false) means don't create new session if one does not exist
	HttpSession session = request.getSession(false);

	if (session != null) {
		String userId = (String) session.getAttribute("userid");
		if (userId == null) {
			out.println("No UserId was found in session.<br>");
		} else {
			out.println("UserId obtained from session :" + userId + "<br>");
			out.println("<a href='logout'>Logout of session</a><br>");
			
}
	}
	else {
		out.println("No session exits for the user. <br>");
	}
}
}

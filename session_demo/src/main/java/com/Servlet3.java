package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import dto.User;


public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session != null ) {
			User u = (User) session.getAttribute("user");
			u.setCity(request.getParameter("city"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			
			
			PrintWriter out = response.getWriter();
			out.println("<h2> hello " + u.getEmail() + " </h2>");
			out.println("<h3> Details.. " + u+ " </h3>");
			out.println("<h4> Session Id is " + session.getId() + " </h4>");
			out.println("<h4> Session created at " + session.getCreationTime() + " </h4>");
			session.invalidate();
			
		
		}
	}
   
}

package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dto.User;


public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session != null ) {
			User u = (User) session.getAttribute("user");
			u.setEmail(request.getParameter("email"));
			u.setAge(Integer.parseInt(request.getParameter("age")));
			session.setAttribute("user", u);
			response.sendRedirect("three.html");
		
		}
	}

}

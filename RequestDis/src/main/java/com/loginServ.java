package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import java.io.PrintWriter;

public class loginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		RequestDispatcher rd=null;
		if(username.equalsIgnoreCase("luffy") && password.equals("mugiwara")) {
			rd=request.getRequestDispatcher("Servlet");
			rd.forward(request, response);
		}else {
			rd=request.getRequestDispatcher("login.html");
			PrintWriter out=response.getWriter();
			rd.include(request, response);
			out.println("Invalid Credentials");
		}
	}

}

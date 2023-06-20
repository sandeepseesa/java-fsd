package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;


public class ServLife extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    public void init() throws ServletException {
	        super.init();
	        System.out.println("Servlet initialized!");
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        System.out.println("Servlet is handling a POST request!");
	        
	        String name = request.getParameter("name");
	        int age = Integer.parseInt(request.getParameter("age"));

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	        out.println("<data>");
	        out.println("<name>" + name + "</name>");
	        out.println("<age>" + age + "</age>");
	        out.println("</data>");
	    }

	    @Override
	    public void destroy() {
	        super.destroy();
	        System.out.println("Servlet is being destroyed!");

}
}

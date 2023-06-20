package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.*;

@WebServlet("/init")
public class HinernateInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		//STEP 1: Get a Session (connection) from the session Factory class
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//Step2 Create the session object
		Session session = factory.openSession();
		
		out.println("Hibernate Session opened.<br>");
		
		session.close();
		
		out.println("Hibernate Session closed.<br>");
		
		out.println("</body></html>");
	}

}

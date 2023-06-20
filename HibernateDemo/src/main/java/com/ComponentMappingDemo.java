package com;

import java.io.*;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hibernate.*;
import com.ecommerce.*;

@WebServlet("/component_mapping-demo")
public class ComponentMappingDemo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

	
		// STEP 3 Query the DB and get the data
		List<EProduct> eproducts = session.createQuery("from EProduct").list();
out.println("<table border=1>");
		
		for (EProduct prod : eproducts) {
			out.println("<tr>" + "<td>" + prod.getID() + "<td>" + prod.getName() + "<td>" + prod.getPrice() + "<td>"
					+ prod.getDateAdded());
			
			ProductParts parts = prod.getParts();
			out.println("<td> Parts =" + parts.getCpu() + ", " + parts.getHdd() + ", " + parts.getRam());
			
		}
		
		out.println("</table>");

		session.close();

		out.println("</body></html>");
	}

}

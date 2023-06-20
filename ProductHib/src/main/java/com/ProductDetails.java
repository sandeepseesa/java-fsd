package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.EProduct;

@WebServlet("/product")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			
			String name =request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			
			
			
			
			try (
				Session session = HibernateUtil.getSessionFactory().openSession()) {
	            Transaction transaction = session.beginTransaction();
	            EProduct pro = new EProduct();
				pro.setName(name);
				pro.setPrice(price);
	            session.save(pro);
	            transaction.commit();
	            session.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	           
	        }
			
			out.print(name + " added into the database");
			
//			out.println("<html><body>");
//			
			//STEP 1: Get a Session (connection) from the session Factory class
//			SessionFactory factory = HibernateUtil.getSessionFactory();
//			
//			//Step2 Create the session object
//			Session session = factory.openSession();
//			
//			//Step3 Query the DB And get the data
//			List<EProduct> eproducts = session.createQuery("from EProduct").list();
//			
//			out.println("<table border=1>");
//
//			for (EProduct prod : eproducts) {
//				out.println("<tr>" + "<td>" + prod.getID() + "<td>" + prod.getName() + "<td>" + prod.getPrice() + "<td>"		
//						+ prod.getDateAdded());
//			}
//
//			out.println("</table>");
//			
//			session.close();
//			
//			
//			out.println("</body></html>");
		}
}

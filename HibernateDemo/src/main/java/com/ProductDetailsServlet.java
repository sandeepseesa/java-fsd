package com;

import java.io.*;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hibernate.*;
import com.ecommerce.*;

@WebServlet("/product-details")
public class ProductDetailsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		// STEP 3 Query the DB and get the data
		List<EProduct> eproducts = session.createQuery("from EProduct").list();

		out.println("<table border=1><th>ID<th>NAME<th>PRICE<th>DATE_ADDED<th>COLORS<th>OS<th>SCREENSIZES<th>FINANCE</th>");


		
		for (EProduct prod : eproducts) {
			out.println("<tr>" + "<td>" + prod.getID() + "<td>" + prod.getName() + "<td>" + prod.getPrice() + "<td>"
					+ prod.getDateAdded());
			
			// Display the colors the product is available in
			List<Color> colors = prod.getColors();
			out.print("<td>");
			for(Color color: colors)
				out.println(color.getName());
			
			//Display the OS the product is avilable in
			Set<OS> Oses = prod.getOs();
			out.println("<td>");
			for (OS os : Oses)
				out.println(os.getName());

			// Display the Screen Sizes the product is available in
			Collection<ScreenSizes> screenSizes = prod.getScreenSizes();
			out.println("<td>");
			for (ScreenSizes ss : screenSizes)
				out.println(ss.getSize());
			
//			Map finances = prod.getFinance();
//			out.println("<td>");
//            if (finances.get("CREDITCARD") != null) {
//                   Finance f = (Finance) finances .get("CREDITCARD");
//                   out.println(f.getName() + " &nbsp;");
//            }
//            if (finances .get("BANK") != null) {
//                   Finance f = (Finance) finances .get("BANK");
//                   out.println(f.getName() + " &nbsp;");
//            }

		}
		
		out.println("</table>");

		session.close();
		out.println("</body></html>");
				
}
}
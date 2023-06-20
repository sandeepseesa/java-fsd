package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("userid");
		
		response.sendRedirect("Servlet2?userid=" + userid);
		
		out.println("I am Servlet2. got uerid using URL rewriting" + userid);
	
	}

}

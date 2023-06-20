package Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;

public class LogValid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		
		
		if (name.equals("luffy")) {
			if( pass.equals("mugiwara")){
				
				response.sendRedirect("dashboard.html");
		}else {
			out.println("Password is you entered is wrong. Please Re-enter");
		} 
		}else	{
			out.print("Username entered is wrong. Please Re-enter");
		}
		

		response.setContentType("text/html");
	}

}

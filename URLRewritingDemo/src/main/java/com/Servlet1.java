package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// create a form with hidden and pass this information to Servlet1
		String userId = request.getParameter("userid");

		out.println("<form action='Servlet2' method='POST'>");
		out.println("<input type='hidden' name='userid' id='userid' value='" + userId + "'>");
		out.println("<input type='submit' value='submit' >");
		out.println("</form>");
		out.println("<script>document.forms[0].submit();</script>");

	}


}

package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@WebServlet("/create-drop-demo")
public class CreateDropDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection = null;

	@Override
	public void init() throws ServletException {
		super.init();
		// Load the DB properties from the config file
		InputStream in = getServletContext().getResourceAsStream("config.properties");

		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			System.out.println(e);
		}

		DBUtil dbutil = new DBUtil(props.getProperty("url"), props.getProperty("userid"),
				props.getProperty("password"));

		connection = dbutil.getConnection();
		System.out.println("DB Connection initialized successfully!.<br>");

}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		//Step3:
		try {
			Statement stmt = connection.createStatement();
			//stmt.execute("CREATE DATABASE SAMPLE1");

			//out.println("Succesfully created datbase Sample1");
			stmt.execute("DROP DATABASE SAMPLE1");
			out.println("Succesfully dropped datbase Sample1");
		}catch (SQLException e) {
			e.printStackTrace();
		}

		out.println("</body></html>");
	}
	@Override
	public void destroy() {		
		super.destroy();
		try {
			connection.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}
}
       
   
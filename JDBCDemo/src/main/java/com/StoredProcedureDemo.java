package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.sql.*;

@WebServlet("/storedprocedure-demo")
public class StoredProcedureDemo extends HttpServlet {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		try {
			CallableStatement callableStmt = 
					connection.prepareCall(" { call add_product(?,?) }");
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			
			callableStmt.setString(1, request.getParameter("name"));
			callableStmt.setString(2, request.getParameter("price"));
			
			callableStmt.execute();
			
			out.println("Added  1 product ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

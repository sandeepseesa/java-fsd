package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import jakarta.servlet.http.*;


@WebServlet("/prod")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection conn = null;

	@Override
	public void init() throws ServletException {
		super.init();
		InputStream in = getServletContext().getResourceAsStream("config.properties");

		Properties props = new Properties();
		// Load the DB properties from the config file
		/*String jdbcUrl = "jdbc:mysql://localhost:3306/ecommerce";
        String username = "root";
        String password = "MySQLpassword";*/
        
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DBUtil dbutil = new DBUtil(props.getProperty("url"), props.getProperty("userid"),
				props.getProperty("password"));

		conn = dbutil.getConnection();
		System.out.println("DB Connection initialized successfully!.<br>");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 	response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String productId = request.getParameter("productId");

	        try {
	            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE ID = ? ");
	            stmt.setString(1, productId);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	            	//int ID =rs.getInt("ID");
	                String name = rs.getString("name");
	                int price = rs.getInt("price");
	                String des=rs.getString("description");

	                out.println("<h2>Product Details:</h2>");
	                out.println("<p><strong>Product ID:</strong> " + productId + "</p>");
	                out.println("<p><strong>Name:</strong> " + name + "</p>");
	                out.println("<p><strong>Price:</strong> " + price + "</p>");
	                out.println("<p><strong>Description:</strong> " + des + "</p>");
	                //out.println("<p><strong>Description:</strong> " + description + "</p>");
	            } else {
	                out.println("<p>Product not found.</p>");
	            }

	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

    @Override
    public void destroy() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

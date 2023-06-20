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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;

@WebServlet("/prepared-statement-demo")
public class PreparedStaementDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connection=null;
    
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
		
		//Step3: create the prepare statement
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM eproduct where price>? and price<?" );
			pstmt.setFloat(1, 10000.0f);
			pstmt.setFloat(2, 50000.0f);
			
			pstmt.execute();
		//Step4: Get the results (row data) from server	
			ResultSet rs = pstmt.getResultSet();
			
			out.println("eproduct Table data<br>");
			while(rs.next()) {
					String ID =rs.getString("ID");
					String name =rs.getString("name");
					float price =rs.getFloat("price");
					String date_added =rs.getString("date_added");
					
					out.println( ID + ", " + name + "," +price + ", " + date_added + "<br>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		out.println("</body></html>");

    }
 // Demo inserting new row using Prepared statement
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			PrintWriter out= response.getWriter();
			try {
 			PreparedStatement pStmt2 = 
 					connection.prepareStatement("INSERT INTO eproduct(name,price) values(?, ?)");
 			
 			pStmt2.setString(1, request.getParameter("name"));
 			pStmt2.setString(2, request.getParameter("price"));
 			
 			pStmt2.execute();
 			
 			out.println("Added  1 product ");
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
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

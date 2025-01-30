package com.CNG_Backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pumplogin
 */
public class pumplogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pumplogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Connection con = DbConnection.connect(); // Ensure this method works correctly
	    int mobile = Integer.parseInt(request.getParameter("mobile"));
	    String password = request.getParameter("password");

	    try {
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM pump_login WHERE MOBILE = ? AND PASSWORD = ?");
	        ps.setInt(1, mobile);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            int id = rs.getInt("ID");
	            GetSet.setId(id);

	            response.sendRedirect("PumpDashBoard.html");
	        } else {
	            response.sendRedirect("PumpLogin.html");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Optionally, redirect to an error page or show an error message
	        response.sendRedirect("error.html");
	    }
	}

}

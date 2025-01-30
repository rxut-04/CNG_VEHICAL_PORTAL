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
 * Servlet implementation class viewregisterpump
 */
public class viewregisterpump extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewregisterpump() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			Connection con = DbConnection.connect();
			String data = request.getParameter("search_query");
			System.out.println(data);
			try {
				PreparedStatement ps1 = con.prepareStatement("SELECT * FROM pump_data WHERE CITY LIKE ? OR TALUKA LIKE ? OR DISTRICT LIKE ?");
				ps1.setString(1, "%" + data + "%");
	            ps1.setString(2, "%" + data + "%");
	            ps1.setString(3, "%" + data + "%");
	            ResultSet rs = ps1.executeQuery();
	            
	            request.setAttribute("searchResult", rs);
	            request.getRequestDispatcher("viewregisterpumps.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

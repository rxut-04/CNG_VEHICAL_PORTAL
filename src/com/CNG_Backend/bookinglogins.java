package com.CNG_Backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bookinglogins
 */
public class bookinglogins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookinglogins() {
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
		
		String name = request.getParameter("name");

		int mobile = Integer.parseInt(request.getParameter("mobile"));

		String city = request.getParameter("city");
		
		try{
			PreparedStatement ps = con.prepareStatement("insert into booking_data values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setInt(3, mobile);
			ps.setString(4, city);
			
			
			int a = ps.executeUpdate();
			if(a > 0){
				response.sendRedirect("bookcng.jsp");
			}else{
				response.sendRedirect("bookinglogin.html");
			}
			
		}catch(SQLException w){
			w.printStackTrace();
		}
		
		doGet(request, response);
	}

}

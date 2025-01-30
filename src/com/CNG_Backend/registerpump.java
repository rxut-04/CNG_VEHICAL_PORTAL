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
 * Servlet implementation class registerpump
 */
public class registerpump extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerpump() {
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
		String name = request.getParameter("P_NAME");
		String address = request.getParameter("ADDRESS");
		String city = request.getParameter("CITY");
		String taluka = request.getParameter("TALUKA");
		String district = request.getParameter("DISTRICT");
		String open_time = request.getParameter("OPEN_TIME");
		String close_time = request.getParameter("CLOSE_TIME");
		int mob = Integer.parseInt(request.getParameter("MOBILE"));
		String latitude = request.getParameter("LATITUDE");
		String longitude = request.getParameter("LONGITUDE");
		String pass = request.getParameter("PASSWORD");
		int cng_gas = Integer.parseInt(request.getParameter("CNG_GAS"));
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into pump_data values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, city);
			ps.setString(5, taluka);
			ps.setString(6, district);
			ps.setString(7, open_time);
			ps.setString(8, close_time);
			ps.setInt(9, mob);
			ps.setString(10, latitude);
			ps.setString(11, longitude);
			ps.setString(12, pass);
			ps.setInt(13, cng_gas);
			
			int a = ps.executeUpdate();
			if(a > 0){
				response.sendRedirect("PumpDashBoard.html");
			}else{
				response.sendRedirect("RegisterPump.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		doGet(request, response);
	}

}

package com.CNG_Backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CNG_Backend.DbConnection;

/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
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
		String email = request.getParameter("email");
		int mobile = Integer.parseInt(request.getParameter("mobile"));
		String password = request.getParameter("password");
		String city = request.getParameter("city");
		
		
		try{
			PreparedStatement ps = con.prepareStatement("insert into user_login values(?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setInt(4, mobile);
			ps.setString(5, password);
			ps.setString(6, city);
			
			
			int a = ps.executeUpdate();
			if(a > 0){
				response.sendRedirect("UserLogin.html");
			}else{
				response.sendRedirect("signup.html");
			}
			
		}catch(SQLException w){
			w.printStackTrace();
		}
		doGet(request, response);
	}

}

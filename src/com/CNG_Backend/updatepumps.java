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
 * Servlet implementation class updatepumps
 */
public class updatepumps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepumps() {
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
		 int pumpId = Integer.parseInt(request.getParameter("pump_id"));
         int newCNG = Integer.parseInt(request.getParameter("cng_available"));
         
         System.out.println(pumpId);
         System.out.println(newCNG);
         
         try {
        	 // Process the update form submission
  	       PreparedStatement ps1 = con.prepareStatement("select * from pump_data where ID = ?");
  	       ps1.setInt(1, pumpId);
  	       ResultSet rs = ps1.executeQuery();
  	       while(rs.next()){
  	    	 
  	    	   int oldgas = rs.getInt(13);
  	    	   int NEWCNG = oldgas + newCNG;
  	    	   
  	    	 PreparedStatement psUpdate = con.prepareStatement("UPDATE pump_data SET CNG_GAS = ? WHERE ID = ?");
  	         psUpdate.setInt(1, NEWCNG);
  	         psUpdate.setInt(2, pumpId);
  	       
  	         
  	         int a =  psUpdate.executeUpdate();
  	         
  	         if(a > 0){
  	        	 response.sendRedirect("updatepumps.jsp");
  	         }
  	       }
	        
		
	}catch(SQLException e){
		e.printStackTrace();
		}
	}

}

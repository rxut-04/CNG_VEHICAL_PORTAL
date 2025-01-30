package com.CNG_Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection connect(){
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded !");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cng_vehicle_application","root","");
			System.out.println("Connection Established !");
			System.out.println();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return (con);
	}
}

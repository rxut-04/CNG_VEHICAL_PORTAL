package com.CNG_Backend;

public class GetSet {
	static int id;
	static String Status = "Pending";
	public static void setId(int i){
		id = i;
	}
	public static void setStatus(String s){
		Status = s;
	}
	public static int getId(){
		return(id);
	}
	public static String getStatus(){
		return Status;
	}
}

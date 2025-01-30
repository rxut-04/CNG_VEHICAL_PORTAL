<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.CNG_Backend.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Connection con = DbConnection.connect();
	try{
		int id = Integer.parseInt(request.getParameter("id"));
		PreparedStatement pstmt = con.prepareStatement("delete from pump_data where ID = ?");
		pstmt.setInt(1, id);
		int i = pstmt.executeUpdate();
		if(i > 0){
			response.sendRedirect("deletecngpump.jsp");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>
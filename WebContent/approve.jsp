<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.CNG_Backend.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
<style>
    /* Global Styles */
    body, html {
      margin: 0;
      padding: 0;
      font-family: "Raleway", serif;
      background-color: #F7F7F7;
    }

    /* Navbar */
    .navbar {
      background-color: #3E7CB1;
      padding: 10px 20px;
      box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
    }
    .navbar-brand {
      font-size: 1.5rem;
      font-weight: bold;
      color: #fff;
      text-decoration: none;
      display: flex;
      align-items: center;
    }
    .navbar-brand span {
      color: #F9A825;
    }
    .navbar-logo {
      width: 40px;
      height: 40px;
      margin-right: 10px;
      border-radius: 50%;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
    }

    /* Table Container */
    .table-container {
      max-width: 1200px;
      margin: 30px auto;
      background-color: #fff;
      border-radius: 10px;
      padding: 20px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      overflow-x: auto;
    }
    h1 {
      text-align: center;
      margin-bottom: 20px;
      color: #3E7CB1;
    }

    /* Table Styling */
    table {
      width: 100%;
      border-collapse: collapse;
      overflow: hidden;
    }
    th, td {
      text-align: center;
      padding: 15px;
      border-bottom: 1px solid #ddd;
    }
    th {
      background-color: #3E7CB1;
      color: #fff;
      text-transform: uppercase;
      font-size: 0.9rem;
      letter-spacing: 0.5px;
    }
    td {
      color: #555;
      background-color: #f9f9f9;
      font-size: 0.9rem;
      transition: background-color 0.3s ease-in-out;
    }
    tr:hover td {
      background-color: #F9A825; /* Highlight row on hover */
      color: #fff;
    }

    /* Button Styling */
    .btn {
      background-color: #3E7CB1;
      color: #fff;
      font-size: 0.9rem;
      font-weight: bold;
      padding: 8px 15px;
      border-radius: 50px;
      border: none;
      transition: background-color 0.3s ease, transform 0.2s ease;
    }
    .btn:hover {
      background-color: #F9A825;
      transform: translateY(-2px);
    }

    /* Responsive Table */
    @media (max-width: 768px) {
      table th, table td {
        font-size: 0.8rem;
        padding: 10px;
      }
    }

    /* Footer */
    footer {
      text-align: center;
      background-color: #333;
      color: #fff;
      padding: 15px 0;
      margin-top: 30px;
    }
  </style>
</head>
<body>
<%
	Connection con = DbConnection.connect();
	try{
		PreparedStatement ps = con.prepareStatement("select * from pump_data");
		ResultSet rs = ps.executeQuery();
		
%>
  <!-- Navbar -->
  <nav class="navbar">
    <a href="dashboard.html" class="navbar-brand">
      <img src="css/logo.png" alt="Logo" class="navbar-logo"> <!-- Logo before "Pump Approval Dashboard" -->
      Pump <span>Approval Dashboard</span>
    </a>
  </nav>

  <!-- Table Section -->
  <div class="table-container">
    <h1>Pending Pump Approvals</h1>
    <table>
      <thead>
        <tr>
          <th>Pump Name</th>
          <th>Address</th>
          <th>City</th>
          <th>Taluka</th>
          <th>District</th>
          <th>Open Time</th>
          <th>Close Time</th>
          <th>Mobile</th>
          <th>Latitude</th>
          <th>Longitude</th>
          <th>CNG Available (in kg)</th>
          <th>Actions</th>
        </tr>
      </thead>
      <% while(rs.next()) { %>
      <tbody>
        <!-- Example Data Row -->
        <tr>
          <td><%=rs.getString(2) %></td>
          <td><%=rs.getString(3) %></td>
          <td><%=rs.getString(4) %></td>
          <td><%=rs.getString(5) %></td>
          <td><%=rs.getString(6) %></td>
          <td><%=rs.getString(7) %></td>
          <td><%=rs.getString(8) %></td>
          <td><%=rs.getInt(9) %></td>
          <td><%=rs.getString(10) %></td>
          <td><%=rs.getString(11) %></td>
          <td><%=rs.getString(12) %></td>
          <td>
            <button class="btn">Approve</button>
            <button class="btn btn-danger">Reject</button>
          </td>
        </tr>
       <% }
        		}
        		catch(Exception  e){
        			e.printStackTrace();
        		}%>
        <!-- Add more rows as needed -->
      </tbody>
    </table>
  </div>

  <!-- Footer -->
  <footer>
    &copy; 2025 CNG Pump Management System. All Rights Reserved.
  </footer>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
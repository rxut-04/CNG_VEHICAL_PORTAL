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
  .navbar-logo {
    width: 40px;
    height: 40px;
    margin-right: 10px;
    border-radius: 50%;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
  }

  /* Search Form */
  .search-form {
    margin: 30px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    text-align: center;
    animation: slideDown 1.5s ease-in-out;
  }
  .search-form h3 {
    color: #3E7CB1;
    margin-bottom: 20px;
  }
  .search-form input {
    width: 70%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    margin-right: 10px;
    font-size: 1rem;
  }
  .search-form button {
    padding: 10px 20px;
    background-color: #3E7CB1;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.3s ease;
  }
  .search-form button:hover {
    background-color: #F9A825;
    transform: translateY(-2px);
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
    animation: fadeIn 1.5s ease-in-out;
  }

  /* Table Styling */
  table {
    width: 100%;
    border-collapse: collapse;
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

  /* Footer */
  footer {
    text-align: center;
    background-color: #333;
    color: #fff;
    padding: 15px 0;
    margin-top: 30px;
  }

  /* Animations */
  @keyframes fadeIn {
    0% { opacity: 0; transform: translateY(-20px); }
    100% { opacity: 1; transform: translateY(0); }
  }
  @keyframes slideDown {
    0% { opacity: 0; transform: translateY(-50px); }
    100% { opacity: 1; transform: translateY(0); }
  }
</style>
</head>
<body>
<%Connection con  = DbConnection.connect(); %>

  <!-- Navbar -->
  <nav class="navbar">
    <a href="UserDashBoard.html" class="navbar-brand">
      <img src="css/logo.png" alt="Logo" class="navbar-logo">
      User <span>Search Dashboard</span>
    </a>
  </nav>
  
  <!-- Search Form -->
  <div class="search-form">
    <h3>Search Pumps</h3>
    <form action="viewuserpump" method="post">
      <input type="text" name="search_query" placeholder="Enter City, Taluka, District" required>
      <button type="submit">Search</button>
    </form>
  </div>
  
  <!-- Table Section -->
  <div class="table-container">
    <h1>Available Pumps</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
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
        </tr>
      </thead>
      <tbody>
      <% 
ResultSet rs = null; 
try {
    rs = (ResultSet) request.getAttribute("searchResults"); 

    // Move the cursor to the first row of the ResultSet
    if (rs != null && rs.next()) { 
%>
    <tr>
        <td><%= rs.getInt("ID") %></td>
        <td><%= rs.getString("P_NAME") %></td>
        <td><%= rs.getString("ADDRESS") %></td>
        <td><%= rs.getString("CITY") %></td>
        <td><%= rs.getString("TALUKA") %></td>
        <td><%= rs.getString("DISTRICT") %></td>
        <td><%= rs.getString("OPEN_TIME") %></td>
        <td><%= rs.getString("CLOSE_TIME") %></td>
        <td><%= rs.getString("MOBILE") %></td>
        <td><%= rs.getString("LATITUDE") %></td>
        <td><%= rs.getString("LONGITUDE") %></td>
        <td><%= rs.getInt("CNG_GAS") %></td>
    </tr>
<%
        // Loop through remaining rows if any
        while (rs.next()) {
%>
    <tr>
         <td><%= rs.getInt("ID") %></td>
        <td><%= rs.getString("P_NAME") %></td>
        <td><%= rs.getString("ADDRESS") %></td>
        <td><%= rs.getString("CITY") %></td>
        <td><%= rs.getString("TALUKA") %></td>
        <td><%= rs.getString("DISTRICT") %></td>
        <td><%= rs.getString("OPEN_TIME") %></td>
        <td><%= rs.getString("CLOSE_TIME") %></td>
        <td><%= rs.getString("MOBILE") %></td>
        <td><%= rs.getString("LATITUDE") %></td>
        <td><%= rs.getString("LONGITUDE") %></td>
        <td><%= rs.getInt("CNG_GAS") %></td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="12">No results found for your search query.</td>
    </tr>
<%
    }
} catch (Exception e) {
    e.printStackTrace(); // Log the exception for debugging
} 
%>



  <!-- Footer -->
  <footer>
    &copy; 2025 CNG Pump Management System. All Rights Reserved.
  </footer>
</body>
</html>
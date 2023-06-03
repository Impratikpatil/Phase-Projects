package com.ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(value = "/RailwayCrossingServlet")
public class RailwayCrossingServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
// JDBC database URL, username, and password
private static final String DB_URL =
"jdbc:mysql://localhost:3306/railway";
private static final String DB_USERNAME = "root";
private static final String DB_PASSWORD = "Workfolder@55";
protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
String name = request.getParameter("name");
String address = request.getParameter("address");
String landmark = request.getParameter("landmark");
String schedules = request.getParameter("schedules");
String person = request.getParameter("person");
String status = request.getParameter("status");
String favourite = request.getParameter("favourite");

System.out.println(favourite);
try {
// Register JDBC driver
Class.forName("com.mysql.jdbc.Driver");
// Create a connection to the database
Connection conn = DriverManager.getConnection(DB_URL,
DB_USERNAME, DB_PASSWORD);
// Prepare the SQL statement
String sql = "INSERT INTO railway_crossings (name, address,landmark, schedules, person, status,favourite) " +
"VALUES (?, ?, ?, ?, ?, ?,?)";
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, name);
statement.setString(2, address);
statement.setString(3, landmark);
statement.setString(4, schedules);
statement.setString(5, person);
statement.setString(6, status);
statement.setString(7, favourite);
// Execute the statement
int rowsInserted = statement.executeUpdate();
statement.close();
conn.close();
if (rowsInserted > 0) {
// Railway crossing added successfully
response.sendRedirect("GetRailwayDetailsServlet");
} else {
// Failed to add railway crossing
response.getWriter().println("Failed to add railway crossing.Please try again.");
}
} catch (ClassNotFoundException | SQLException e) {
e.printStackTrace();
response.getWriter().println("Database error: " + e.getMessage());
}
}
}

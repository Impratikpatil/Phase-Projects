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
@WebServlet("/DeleteRailwayCrossingServlet")
public class DeleteRailwayCrossingServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
// JDBC database URL, username, and password
private static final String DB_URL =
"jdbc:mysql://localhost:3306/railway";
private static final String DB_USERNAME = "root";
private static final String DB_PASSWORD = "Workfolder@55";
protected void doGet(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id"));
try {
// Register the JDBC driver
Class.forName("com.mysql.jdbc.Driver");
// Create a connection to the database
Connection conn = DriverManager.getConnection(DB_URL,
DB_USERNAME, DB_PASSWORD);
// Prepare the SQL statement
String sql = "DELETE FROM railway_crossings WHERE id = ?";
PreparedStatement statement = conn.prepareStatement(sql);
statement.setInt(1, id);
// Execute the statement
int rowsDeleted = statement.executeUpdate();
statement.close();
conn.close();
if (rowsDeleted > 0) {
// Railway crossing deleted successfully
response.sendRedirect("GetRailwayDetailsServlet");
} else {
// Failed to delete railway crossing
response.getWriter().println("Failed to delete railway crossing. Please try again.");
}
} catch (ClassNotFoundException | SQLException e) {
e.printStackTrace();
response.getWriter().println("Database error: " + e.getMessage());
}
}
}

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
@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
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
String email = request.getParameter("email");
String password = request.getParameter("password");
try {
// Load the MySQL JDBC driver
Class.forName("com.mysql.jdbc.Driver");
// Create a connection to the database
Connection conn = DriverManager.getConnection(DB_URL,
DB_USERNAME, DB_PASSWORD);
// Prepare the SQL statement
String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, name);
statement.setString(2, email);
statement.setString(3, password);
// Execute the statement
int rowsInserted = statement.executeUpdate();
statement.close();
conn.close();
if (rowsInserted > 0) {
// Registration successful, redirect to login page
response.sendRedirect("login.jsp");
} else {
// Registration failed, display an error message
response.getWriter().println("Registration failed. Please try again.");
}
} catch (ClassNotFoundException e) {
e.printStackTrace();
response.getWriter().println("MySQL JDBC driver not found.");
} catch (SQLException e) {
e.printStackTrace();
response.getWriter().println("Database error: " + e.getMessage());
}
}
}

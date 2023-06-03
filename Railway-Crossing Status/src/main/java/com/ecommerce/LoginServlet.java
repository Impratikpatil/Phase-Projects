package com.ecommerce;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
// JDBC database URL, username, and password
private static final String DB_URL =
"jdbc:mysql://localhost:3306/railway";
private static final String DB_USERNAME = "root";
private static final String DB_PASSWORD = "Workfolder@55";
protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
String email = request.getParameter("email");
String password = request.getParameter("password");
try {
// Load the MySQL JDBC driver
Class.forName("com.mysql.jdbc.Driver");
// Create a connection to the database
Connection conn = DriverManager.getConnection(DB_URL,
DB_USERNAME, DB_PASSWORD);
// Prepare the SQL statement
String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, email);
statement.setString(2, password);
// Execute the statement
ResultSet resultSet = statement.executeQuery();
if (resultSet.next()) {
// Login successful, create a session for the user
HttpSession session = request.getSession();
session.setAttribute("email", email);
response.sendRedirect("DashboardServlet");
} else {
// Login failed, display an error message
response.getWriter().println("Invalid email or password. Please try again.");
}
resultSet.close();
statement.close();
conn.close();
} catch (ClassNotFoundException e) {
e.printStackTrace();
response.getWriter().println("MySQL JDBC driver not found.");
} catch (SQLException e) {
e.printStackTrace();
response.getWriter().println("Database error: " + e.getMessage());
}
}
}

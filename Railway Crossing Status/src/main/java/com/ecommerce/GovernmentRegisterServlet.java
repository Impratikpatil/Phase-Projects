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
@WebServlet(value = "/GovernmentRegisterServlet")
public class GovernmentRegisterServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
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
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(DB_URL,
DB_USERNAME, DB_PASSWORD);
String sql = "INSERT INTO admin (name, email, password) VALUES (?, ?, ?)";
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, name);
statement.setString(2, email);
statement.setString(3, password);
int rowsInserted = statement.executeUpdate();
statement.close();
conn.close();
if (rowsInserted > 0) {
response.sendRedirect("government_login.jsp");
} else {
response.getWriter().println("Registration failed. Please try again.");
}
} catch (ClassNotFoundException | SQLException e) {
e.printStackTrace();
response.getWriter().println("Database error: " + e.getMessage());
}
}
}

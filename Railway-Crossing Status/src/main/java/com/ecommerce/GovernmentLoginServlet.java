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

@WebServlet(value = "/GovernmentLoginServlet")
public class GovernmentLoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
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
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(DB_URL,
DB_USERNAME, DB_PASSWORD);
String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, email);
statement.setString(2, password);
ResultSet resultSet = statement.executeQuery();
if (resultSet.next()) {
HttpSession session = request.getSession();
session.setAttribute("email", email);
response.sendRedirect("add_railway.html");
} else {
response.getWriter().println("Invalid email or password. Please try again.");
}
resultSet.close();
statement.close();
conn.close();
} catch (ClassNotFoundException | SQLException e) {
e.printStackTrace();
response.getWriter().println("Database error: " + e.getMessage());
}
}
}

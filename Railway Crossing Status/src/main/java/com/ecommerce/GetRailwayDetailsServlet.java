package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/GetRailwayDetailsServlet")
public class GetRailwayDetailsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
// JDBC database URL, username, and password
private static final String DB_URL =
"jdbc:mysql://localhost:3306/railway";
private static final String DB_USERNAME = "root";
private static final String DB_PASSWORD = "Workfolder@55";
protected void doGet(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
try {
// Create a connection to the database
Connection conn = DriverManager.getConnection(DB_URL,
DB_USERNAME, DB_PASSWORD);
// Prepare the SQL statement
String sql = "SELECT * FROM railway_crossings";
PreparedStatement statement = conn.prepareStatement(sql);
// Execute the query
ResultSet resultSet = statement.executeQuery();
// Generate HTML output
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Railway Crossings</title>");
out.println("</head>");
out.println("<body>");
out.println("<h1>Railway Crossings</h1>");
out.println("<table>");
out.println("<tr><th>ID</th><th>Name</th><th>Address</th><th>Landmar k</th><th>Schedules</th><th>Person</th><th>Status</th></tr>");
while (resultSet.next()) {
int id = resultSet.getInt("id");
String name = resultSet.getString("name");
String address = resultSet.getString("address");
String landmark = resultSet.getString("landmark");
String schedules = resultSet.getString("schedules");
String person = resultSet.getString("person");
String status = resultSet.getString("status");
String favourite = resultSet.getString("favourite");
out.println("<tr>");
out.println("<td>" + id + "</td>");
out.println("<td>" + name + "</td>");
out.println("<td>" + address + "</td>");
out.println("<td>" + landmark + "</td>");
out.println("<td>" + schedules + "</td>");
out.println("<td>" + person + "</td>");
out.println("<td>" + status + "</td>");
out.println("<td>" + favourite + "</td>");

out.println("<td><a href='update_railway.jsp?id=" + id +
"'>Update</a> | <a href='DeleteRailwayCrossingServlet?id=" + id +
"'>Delete</a></td>");
out.println("</tr>");
}
out.println("</table>");
out.println("</body>");
out.println("</html>");
statement.close();
conn.close();
} catch (SQLException e) {
e.printStackTrace();
out.println("Database error: " + e.getMessage());
}
}
}

package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/FavoriteCrossingsServlet")
public class FavoriteCrossingsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
// JDBC database URL, username, and password
private static final String DB_URL = "jdbc:mysql://localhost:3306/railway";
private static final String DB_USERNAME = "root";
private static final String DB_PASSWORD = "Workfolder@55";
// JDBC driver and connection variables
private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
private Connection conn;
@Override
public void init() throws ServletException {
super.init();
try {
// Register JDBC driver
Class.forName(JDBC_DRIVER);
// Open a connection to the database
conn = DriverManager.getConnection(DB_URL, DB_USERNAME,
DB_PASSWORD);
} catch (ClassNotFoundException | SQLException e) {
e.printStackTrace();
throw new ServletException("Database connection error: " +
e.getMessage());
}
}
@Override
public void destroy() {
super.destroy();
try {
// Close the database connection
if (conn != null && !conn.isClosed()) {
conn.close();
}
} catch (SQLException e) {
e.printStackTrace();
}
}
protected void doGet(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
try {
	
	
// Retrieve favorite crossings from session
List<Integer> favoriteCrossings = (List<Integer>)
request.getSession().getAttribute("favoriteCrossings");
System.out.println(favoriteCrossings);
// Generate HTML output
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Favorite Railway Crossings</title>");
out.println("</head>");
out.println("<body>");
out.println("<h1>Favorite Railway Crossings</h1>");
if (favoriteCrossings == null || favoriteCrossings.isEmpty()) {
out.println("<p>No favorite crossings found.</p>");
} else {
// Prepare the SQL statement
String sql = "SELECT * FROM railway_crossings WHERE id IN (";
for (int i = 0; i < favoriteCrossings.size(); i++) {
sql += favoriteCrossings.get(i);
if (i < favoriteCrossings.size() - 1) {
sql += ",";
}
}
sql += ")";
PreparedStatement statement = conn.prepareStatement(sql);
// Execute the query
ResultSet resultSet = statement.executeQuery();
out.println("<table>");
out.println("<tr><th>ID</th><th>Name</th><th>Address</th><th>Landmark</th><th>Schedules</th><th>Person</th><th>Status</th></tr>");
while (resultSet.next()) {
int id = resultSet.getInt("id");
String name = resultSet.getString("name");
String address = resultSet.getString("address");
String landmark = resultSet.getString("landmark");
String schedules = resultSet.getString("schedules");
String person = resultSet.getString("person");
String status = resultSet.getString("status");
out.println("<tr>");
out.println("<td>" + id + "</td>");
out.println("<td>" + name + "</td>");
out.println("<td>" + address + "</td>");
out.println("<td>" + landmark + "</td>");
out.println("<td>" + schedules + "</td>");
out.println("<td>" + person + "</td>");
out.println("<td>" + status + "</td>");
out.println("</tr>");
}
out.println("</table>");
statement.close();
}
out.println("</body>");
out.println("</html>");
} catch (SQLException e) {
e.printStackTrace();
out.println("Database error: " + e.getMessage());
}
}
}

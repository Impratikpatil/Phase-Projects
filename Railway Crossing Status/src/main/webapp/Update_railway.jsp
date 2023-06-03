<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Update Railway Crossing</h1>
<h1>Update Railway Crossing</h1>
<%
// Retrieve the railway crossing details from the request parameters
int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String address = request.getParameter("address");
String landmark = request.getParameter("landmark");
String schedules = request.getParameter("schedules");
String person = request.getParameter("person");
String status = request.getParameter("status");
%>
<form action="UpdateRailwayCrossingServlet" method="post">
<input type="hidden" name="id" value="<%= id %>">
<label for="name">Name:</label>
<input type="text" name="name" id="name" value="<%= name %>">
<br>
<label for="address">Address:</label>
<input type="text" name="address" id="address" value="<%= address
%>">
<br>
<label for="landmark">Landmark:</label>
<input type="text" name="landmark" id="landmark" value="<%=
landmark %>">
<br>
<label for="schedules">Schedules:</label>
<input type="text" name="schedules" id="schedules" value="<%=
schedules %>">
<br>
<label for="person">Person:</label>
<input type="text" name="person" id="person" value="<%= person
%>">
<br>
<label for="status">Status:</label>
<input type="text" name="status" id="status" value="<%= status %>">
<br>
<input type="submit" value="Update">
</form>
</body>
</html>



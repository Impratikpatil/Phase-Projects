<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><head>
<title>Add Railway Crossing</title>
</head>
<body>
<h1>Add Railway Crossing</h1>
<form action="RailwayCrossingServlet" method="POST">
<label for="name">Name:</label>
<input type="text" id="name" name="name" required="">
<br><br>
<label for="address">Address:</label>
<input type="text" id="address" name="address" required="">
<br><br>
<label for="landmark">Landmark:</label>
<input type="text" id="landmark" name="landmark" required="">
<br><br>
<label for="schedules">Train Schedules:</label>
<textarea id="schedules" name="schedules" required=""></textarea>
<br><br>
<label for="person">Person in Charge:</label>
<input type="text" id="person" name="person" required="">
<br><br>
<label for="status">Status:</label>
<select id="status" name="status" required="">
<option value="Open">Open</option>
<option value="Closed">Closed</option></select>

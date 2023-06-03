<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Railway Crossing</h1>
<h2>User Login</h2>
<form method="post" action="login">
<label for="email">Enter Email:</label>
<input type="email" id="email" name="email" required><br><br>
<label for="password">Enter Password:</label>
<input type="password" id="password" name="password"
required><br><br>
<input type="submit" value="Login">
</form>
<br>
<p>Don't have an account? <a href="register.jsp">Create New
Account</a></p>
</body>
</html>

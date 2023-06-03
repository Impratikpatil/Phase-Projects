<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.submitted-value {
color: green;
}
</style>
</head>
<body>
<h1>Railway Crossing</h1>
<h2>User Register</h2>
<form method="post" action="register">
<label for="name">Enter Name:</label>
<input type="text" id="name" name="name" required><br><br>
<label for="email">Enter Email:</label>
<input type="email" id="email" name="email" required><br><br>
<label for="password">Enter Password:</label>
<input type="password" id="password" name="password"
required><br><br>
<input type="submit" value="Register">
</form>
<br>
<p>Already have an account? <a href="login.jsp">Login</a></p>
</body>
</html>
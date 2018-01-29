<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action="login" method="post">
		UserName:<br><input type="text" name="username">
		<br>
		<br>
		Password:<br><input type="password" name="password">
		<br>
		<br>
		<br>
		<br>
		<input type="submit" value="submit">
	</form>
<%-- 	 <button type="button" onclick='<jsp:forward page="/register.jsp"></jsp:forward>'>[Don't have account]Register Here!</button> 
 --%>	 <a href="register.jsp">Register Here</a>
	 ${message }
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="register" method="post">
		UserName:<br><input type="text" name="username">
		<br>
		<br>
		Password:<br><input type="password" name="password">
		<br>
		<br>
		Email-Id:<br><input type="text" name="email">
		<br>
		<br>
		<br>
		<br>
		<input type="submit" value="Register">
	</form>
	<%-- <button type="button" onclick='<jsp:forward page="/login.jsp"></jsp:forward>'>[Already have account]Login Here!</button> --%>
	<a href="login.jsp">Login Here</a>
	${message }

</body>
</html>
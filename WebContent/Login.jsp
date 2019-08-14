<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Validation">
	Username:
	<input type="text" name="unm" value="${username}"><font color="red">${err1}</font>
	<br>
	Password:
	<input type="password" name="pwd" value="${password}"><font color="red">${err2}</font>
	<br>
	<input type="submit" value="Login">
	<input type="reset" value="Reset">
</form>
</body>
</html>
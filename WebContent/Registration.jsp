<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form action="registration" method="post">
First Name:
<input type="text" name="Fname" placeholder="Enter First Name" value="${fname}"><font color="red">${err1}</font>
</br>
Last Name:
<input type="text" name="Lname" placeholder="Enter Last Name" value="${lname}"><font color="red">${err2}</font>
</br>
Address:
<textarea rows="3" cols="10" name="Address" value="${address}"></textarea><font color="red">${err3}</font>
</br>
Gender:
<input type="radio" name="Gender" value="Male">Male
<input type="radio" name="Gender" value="Female">Female
</br>
MobileNo:
<input type="number" name="MobileNo" value="${mobileNo}"><font color="red">${err4}</font>
</br>
Email:
<input type="text" name="Email" value="${email}"><font color="red">${err5}</font>
</br>
Hobby:
<input type="checkbox" name="hobby" value="Swimming">Swimming
<input type="checkbox" name="hobby" value="Dancing">Dancing
<input type="checkbox" name="hobby" value="Reading">Reading
<input type="checkbox" name="hobby" value="Singing">Singing
</br>
<input type="hidden" name="flag" value="insert"></br>
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>
Search Data
<a href="Search">Search</a>
</body>
</html>
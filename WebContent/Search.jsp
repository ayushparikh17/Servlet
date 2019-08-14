<%@page import="java.util.Iterator"%>
<%@page import="com.project.bean.RegistrationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Data</title>
</head>
<body>
<table border="1">
<tr>
<td>Id</td>
<td>FirstName</td>
<td>LastName</td>
<td>Address</td>
<td>Gender</td>
<td>MobileNO</td>
<td>Email</td>
<td>Hobby</td>
<td>Action</td>
</tr>
<%
HttpSession s=request.getSession();
ArrayList<RegistrationBean> ls=null;
ls=(ArrayList<RegistrationBean>)s.getAttribute("list");
Iterator<RegistrationBean> itr=ls.iterator();
while(itr.hasNext()){
	RegistrationBean bean=itr.next();
%>
<tr>
<td><%=bean.getId() %></td>
<td><%=bean.getFirstName() %></td>
<td><%=bean.getLastName() %></td>
<td><%=bean.getAddress() %></td>
<td><%=bean.getGender() %></td>
<td><%=bean.getMobileno() %></td>
<td><%=bean.getEmail() %></td>
<td><%=bean.getHobby() %></td>
<td><a href="registration?id=<%=bean.getId()%>&flag=edit">Edit</a>/<a href="registration?id=<%=bean.getId()%>&flag=delete">Delete</a></td>
</tr>
<%	
}
%>
</table>
</body>
</html>
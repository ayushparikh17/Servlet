<%@page import="java.util.Iterator"%>
<%@page import="com.project.bean.RegistrationBean"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

asdasd

<%
HttpSession s=request.getSession();
ArrayList<RegistrationBean> ls=null;
ls=(ArrayList<RegistrationBean>)s.getAttribute("list1");
Iterator<RegistrationBean> itr=ls.iterator();
while(itr.hasNext()){
	RegistrationBean bean=itr.next();
%>
<form action="Update" method="post">
<input type="hidden" value="<%=bean.getId() %>" name="id">
First Name:
<input type="text" name="Fname" value="<%=bean.getFirstName()%>">
</br>
Last Name:
<input type="text" name="Lname" value="<%=bean.getLastName()%>">
</br>
Address:
<textarea rows="3" cols="10" name="Address"><%=bean.getAddress()%></textarea>
</br>
MobileNo:
<input type="number" name="MobileNo" value="<%=bean.getMobileno() %>">
</br>
Email:
<input type="text" name="Email" value="<%=bean.getEmail()%>">
</br>
<input type="hidden" name="flag" value="update">
<input type="submit" value="Update">
</form>
<%
}
%>
</body>
</html>
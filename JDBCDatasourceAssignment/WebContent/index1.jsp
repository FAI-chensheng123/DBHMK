<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.jdbc.ds.dao.*, edu.neu.cs5200.jdbc.ds.model.*, java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
        <%
            UserDAO userDAO = new UserDAO();
        	
        	User user = new User();
        	user.setUsername("csneu");
        	user.setPassword("123");
        	user.setLastname("chen");
        	user.setFirstname("sheng");
        	user.setEmail("com");
        	
        	Date d = new Date(2005/8/24);
        	
        	user.setDateofbrith(d);
        	
        	
   			userDAO.create(user);   		
   
        %>



</body>
</html>
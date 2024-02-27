<%@page import="com.online.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Customer</title>
</head>
<body>
<h1>Register Customer</h1>
<form action="RegisterServlet" method="post">
    Customer Id: <input type="text" name="customerId" placeholder="customerId" /> <br/><br/>
    Customer Name: <input type="text" name="customerName" placeholder="customerName" /> <br/><br/>
    Customer City: <input type="text" name="customerCity" placeholder="customerCity" /> <br/><br/>
    Customer Password: <input type="password" name="customerPassword" placeholder="customerPassword" /> <br/><br/>
    Customer Email: <input type="text" name="customerEmail" placeholder="customerEmail" /> <br/><br/>
    <button type="submit">Submit</button>
</form>
<br/> 
</form>
 <!-- Button for login -->
    <form action="login_page.jsp">
        <button type="submit">Login</button>
    </form>
</body>
</html>

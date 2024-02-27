<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.online.entites.Customer" %>

<%
    Customer customer = (Customer) session.getAttribute("CurrentUser");
    if (customer == null) {
        response.sendRedirect("login.jsp");
        return; // Add this line to stop further execution
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <%= customer.getCustomerName() %>
    <br/>
    <%= customer.getCustomerEmail() %>
    <br/>
    <%= customer.getCustomerCity() %>
    
    </form>
 <!-- Button for login -->
    <form action="logout.jsp">
        <button type="submit">Logout</button>
    </form>
</body>
</html>

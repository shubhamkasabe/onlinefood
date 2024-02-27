<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login here</title>
</head>
<body>
<h1>Login Here</h1>
<form action="LoginServlet" method="post">
<input type="email" name="email" placeholder="Enter EmailId"/> <br/>  <br/>
<input type="password" name="password" placeholder="Enter Password" />  <br/>  <br/>
<button type="submit">submit</button>

</form>
 <!-- Button for login -->
    <form action="index.jsp">
        <button type="submit">Signup</button>
    </form>
</body>
</body>
</html>
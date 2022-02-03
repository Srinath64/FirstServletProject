<%--
  Created by IntelliJ IDEA.
  User: srinath
  Date: 03/02/22
  Time: 8:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Success Page</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("user") %>, Login Successfull.</h3>
<a href = "login.html">Login Page</a>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
</head>
<body>
    <h1>Product Details</h1>
    <p>Name: <%= session.getAttribute("Name") %></p>
    <p>Price: <%= session.getAttribute("Price") %></p>
    
</body>
</html>

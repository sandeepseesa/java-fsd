<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <b>Hello <%= session.getAttribute("name") %></b><br>

<a href="logout.jsp">Click here to logout</a>
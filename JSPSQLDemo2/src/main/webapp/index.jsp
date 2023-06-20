<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sql:setDataSource var="ecomm" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/ecommerce" user="root"	password="MySQLpassword" />

<sql:query dataSource="${ecomm}" sql="SELECT * FROM eproduct"	var="result" />

<table border=1>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Price</th>
		<th>Date Added</th>
	</tr>

	<c:forEach var="row" items="${result.rows}">
		<tr>
			<td><c:out value="${row.id}" /></td>
			<td><c:out value="${row.name}" /></td>
			<td><c:out value="${row.price}" /></td>
			<td><c:out value="${row.date_added}" /></td>
		</tr>

	</c:forEach>

</table>
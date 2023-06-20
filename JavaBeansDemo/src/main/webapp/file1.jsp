<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>JSP JAVABEANS demo (file1.jsp)</h3>
<h2>In this JSP, we will access productBean101 ProductBean that was created in another JSP(index.jsp) and
	print its properties.</h2>


<jsp:useBean id="productBean101" class="com.ProductBean"	scope="session"></jsp:useBean>

Product Id:<jsp:getProperty name="productBean101" property="productId" />
<br>
Product Name:<jsp:getProperty name="productBean101" property="productName" />
<br>
Product Price:<jsp:getProperty name="productBean101" property="price" />
<br>

<h2>Display properties captured from the form submission</h2>
<jsp:useBean id="productBean111" class="com.ProductBean"	scope="session"></jsp:useBean>

Product Id:<jsp:getProperty name="productBean111" property="productId" />
<br>
Product Name:<jsp:getProperty name="productBean111" property="productName" />
<br>
Product Price:<jsp:getProperty name="productBean111" property="price" />
<br>
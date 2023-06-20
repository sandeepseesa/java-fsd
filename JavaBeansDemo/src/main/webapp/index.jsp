<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>JSP JAVABEANS demo</title>

<h3>JSP JAVABEANS demo</h3>
<h2>In this JSP, we have created a ProductBean object. It is stored in productBean101 variable.</h2>
<h2>and put in the session object. It can accessed in other JSPs!.</h2>


<jsp:useBean id="productBean101" class="com.ProductBean" scope="session"></jsp:useBean>

  <jsp:setProperty property="productId" name="productBean101" value="18791"/>
   <jsp:setProperty property="productName" name="productBean101" value="HP camera X201"/>
    <jsp:setProperty property="price" name="productBean101" value="2500.5"/>
    
    
<h2> Following statements will capture form data and save it in the productBean111 object.</h2>    
<jsp:useBean id="productBean111" class="com.ProductBean" scope="session"></jsp:useBean>
 <jsp:setProperty property="*" name="productBean111" />
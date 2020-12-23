<%-- 
    Document   : newcustomer
    Created on : Dec 21, 2020, 11:18:13 PM
    Author     : konstantinos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Customer</title>
        <link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@ include file="../mymenu.jsp" %> 
            <h1>Register a new Product</h1> 
            <form:form method="POST" action="newproduct" modelAttribute="product">

                <form:input type="hidden" path="id" id="id"/>
                <div class="form-group">
                    Product Name: <form:input class="form-control" path="name" /><br />
                </div>
                <div class="form-group">
                    Product Price: <form:input class="form-control"   path="price" /><br />
                </div>
                <div class="form-group">
                    Product Quantity: <form:input class="form-control" type="number" path="quantity" /><br /> 
                </div>
                <input type="submit">
            </form:form>
            <div id="msg">${message}</div>
            <div id="list"><a href="<c:url value='/${listurl}' />">Back to the list of Products</a></div>
        </div> 
    </body>
</html>

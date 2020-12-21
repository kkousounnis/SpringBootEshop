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
            <h1>Register a new Customer</h1> 
            <form:form method="POST" action="newcustomer" modelAttribute="customer">

                <form:input type="hidden" path="id" id="id"/>
                <div class="form-group">
                    First Name: <form:input class="form-control" path="firstName" /><br />
                </div>
                <div class="form-group">
                    Last Name: <form:input class="form-control" path="lastName" /><br />
                </div>
                <div class="form-group">
                    Telephone: <form:input class="form-control" type="number" path="tel" /><br /> 
                </div>
                <div class="form-group">
                    Email <form:input type="email" class="form-control" path="email" /><br />   
                </div>
                <input type="submit">
            </form:form>
            <div id="msg">${message}</div>
            <div id="list"><a href="<c:url value='/${listurl}' />">Back to the list of Trainers</a></div>
        </div> 
    </body>
</html>

<%-- 
    Document   : listcustomers
    Created on : Dec 21, 2020, 10:32:23 PM
    Author     : konstantinos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers Table</title>
        <link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@ include file="../mymenu.jsp"  %>
            <h1> Customer's List</h1>>
            <table class="table table-hover">
                <tr>
                    <td>Update</td>>
                    <td>First Name</td>>
                    <td>Last Name</td>>
                    <td>Telephone</td>>
                    <td>Email</td>>                    
                </tr>
                <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><a href="<c:url value='${editurl}/${customer.id}'/> ">update </a></td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.tel}</td>
                    <td>${customer.email}</td>
                    <td><a href="<c:url value='${deleteurl}/${customer.id}' />">delete</a></td>
                </tr>
                </c:forEach>
            </table>
            <div id="msg">${msg}</div>
        </div>
    </body>
</html>

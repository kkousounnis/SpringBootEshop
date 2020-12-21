<%-- 
    Document   : editcustomer
    Created on : Dec 22, 2020, 1:36:43 AM
    Author     : konstantinos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Trainer</title>
        <link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@ include file="../mymenu.jsp" %> 
            <h1>Update a Customer</h1>

            <%
                String updateUrlFINAL = request.getContextPath() + "/" + request.getAttribute("updateurl");
                session.setAttribute("updateUrlFINAL", updateUrlFINAL);
            %>
            <form:form method="POST" action="${updateUrlFINAL}" modelAttribute="customer">
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
                <input type="submit" value="Update">
            </form:form>
            <div id="msg">${message}</div>
            <div id="list"><a href="<c:url value='/${listurl}' />">Back to the list of customers</a></div>
        </div>
    </body>
</html>


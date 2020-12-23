<%-- 
    Document   : mymenu
    Created on : Dec 10, 2020, 1:19:25 AM
    Author     : konstantinos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-sm bg-primary navbar-dark">

                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-item nav-link" href="<%=request.getContextPath()%>/customer/newcustomer">New Customer</a>                            
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-item nav-link" href="<%=request.getContextPath()%>/customer/listcustomers"> List Customers</a>                            
                    </li>
                </ul> 
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-item nav-link" href="<%=request.getContextPath()%>/product/newproduct">New Product</a>                            
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-item nav-link" href="<%=request.getContextPath()%>/product/listproducts"> List Products</a>                            
                    </li>
                </ul> 

            </nav>
        </div>
    </div>
</div>

<%-- 
    Document   : product-detail
    Created on : Mar 24, 2023, 6:52:46 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row">
    <div class="col-md-5 col-xs-12">
        <img src="${product.image}" class="img-fluid" />
    </div>
    <div class="col-md-7 col-xs-12">
        <h1 class="text-danger">${product.name}</h1>
        <h2>${product.price}</h2>
        <p class="text-success">${product.description}</p>
    </div>
</div>

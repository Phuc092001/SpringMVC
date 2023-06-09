<%-- 
    Document   : index
    Created on : Mar 24, 2023, 6:52:31 AM
    Author     : ACER
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="p">
            <c:url value="/products/${p.id}" var="detail" />
            <div class="col-md-3 col-xs-12" style="padding:1rem;">
                <div class="card">
                    <img class="card-img-top" src="${p.image}" alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">${p.name}</h4>
                        <p class="card-text">${p.price} VNĐ</p>
                        <a href="${detail}" class="btn btn-primary">Xem chi tiết</a>
                        <a href="#" class="btn btn-danger">Đặt hàng</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

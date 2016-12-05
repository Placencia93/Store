<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Store Front</title>
</head>
<body>
    <form action="Purchase" method="post">
    
        <c:if test="${not empty param.add and empty param.name }">
            <p style="color: #f00">Please enter a valid name</p>
        </c:if>     
        Name: <input type="text" name="name" value="${param.name}"  /> <br />
    
        <c:if test="${not empty param.add and empty param.email }">
            <p style="color: #f00">Please enter a valid email address</p>
        </c:if>
        Email Address: <input type="text" name="email" value="${param.email}" /> <br />     
        
        <button type="submit" class="btn btn-success btn-block">Purchase</button>
    </form>
    
    <table class="table table-hover table-striped table-bordered">
        <thead>
            <tr>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                
            </tr>
        </thead>
        <tbody>
            <c:set var="s" value="0"></c:set>
            <c:forEach items="${shoppingCart}" var="shoppingCart">
                <c:set var="s" value="${ s + shoppingCart.price }"></c:set>
                <tr>                    
                    <td>
                            ${shoppingCart.name}                    
                    </td>
                    
                    <td>
                            ${shoppingCart.quantity}                   
                    </td>
                    
                     <td>
                            ${shoppingCart.price}                   
                    </td>
                    
                </tr>
            </c:forEach>
            <tr>
                    <td colspan ="2" align="right">Total</td>
                    <td>${s}</td>
            </tr>        
        </tbody>
    </table>
    
    <br />
           
    
</body>
</html>
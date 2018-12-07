<%-- 
    Document   : detailedorder
    Created on : 07-12-2018, 11:34:55
    Author     : mwn
--%>

<%@page import="PresentationLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detailed Order</title>
        <% Order order = (Order) request.getAttribute("order"); %>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

<%-- 
    Document   : employeepage
    Created on : Nov 30, 2018, 9:18:49 AM
    Author     : Christian
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="PresentationLayer.HTMLGenerator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Order> list = (List<Order>) request.getSession().getAttribute("OrderList");
    HTMLGenerator html = new HTMLGenerator();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="Ressources/Style.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <body>
        <jsp:include page="navigator.jsp" />

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <table class="table" id="database-table">
                        <%= html.getOrders(list)%>
                    </table>
                </div>
            </div>
        </div>
        <script src="Ressources/empPage.js"></script>
    </body>
</html>

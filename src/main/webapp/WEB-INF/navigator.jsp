<%-- 
    Document   : navigator
    Created on : 14-11-2018, 10:57:06
    Author     : mwn
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="Ressources/Style.css">
    </head>
    <body>
        <%
            User user = (User) request.getSession().getAttribute("user");
        %>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
                <img src="Img/logo.png" alt="test"width="64" height="64">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <%if (user == null) {%>
                    <a class="nav-item nav-link" href="FrontController?command=login">Login</a>
                    <a class="nav-item nav-link" href="FrontController?command=gotocreateuser">Sign up<span class="sr-only">(current)</span></a>
                    <%}%>
                    <%if (user != null) {%>x
                    <%if (user.getRole().equals("admin")) {%>
                    <a class="nav-item nav-link" href="FrontController?command=updatedatabase">Edit products</a>
                    <a class="nav-item nav-link" href="FrontController?command=employeepage">See orders (WIP)</a>
                    <%}%>
                    <%if (user.getRole().equals("customer")) {%>
                    <a class="nav-item nav-link" href="FrontController?command=heightandlength">Send a query</a>
                    <%}%>
                    <a id="logout" class="nav-item nav-link " href="FrontController?command=logout">Logout</a>
                    <%}%>
                </div>
            </div>
        </nav>
    </body>
    <script src="Ressources/navigator.js"></script>
</html>

<%-- 
    Document   : editproducts
    Created on : 14-11-2018, 12:14:00
    Author     : mwn
--%>

<%@page import="PresentationLayer.HTMLGenerator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List list = new ArrayList();
    HTMLGenerator html = new HTMLGenerator();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="Ressources/Style.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="Ressources/Script.js"></script>
        <title>Edit products</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                    <h6 class="second-header">Add/Edit products</h6>
                    <form action="FrontController" method="post">
                        <div class="form-group">
                            <label>Productname</label>
                            <input type="text" class="form-control" name="name" id="name-field">
                            <label>Price</label>
                            <input type="text" class="form-control" name="price" id="price-field">
                            <label>Description</label>
                            <input type="text" class="form-control" name="description" id="desc-field">
                            <label>Length</label>
                            <input type="text" class="form-control" name="length" id="length-field">
                            <label>Unit</label>
                            <input type="text" class="form-control" name="unit" id="unit-field">
                            <label>Type</label>
                            <input type="text" class="form-control" name="type" id="type-field">
                        </div>
                        <input type="hidden" name="command" value="updatedatabase">
                        <input type="submit" class="btn-primary" value="Add">
                    </form>
                </div>
                <div class="col-md-8">
                    <table class="table" id="database-table">
                        <%= html.getDatabase(list)%>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

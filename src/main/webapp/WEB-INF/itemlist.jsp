<%-- 
    Document   : itemlist
    Created on : 14-11-2018, 10:08:12
    Author     : mwn
--%>

<%@page import="java.util.Collection"%>
<%@page import="FunctionLayer.Carport"%>
<%@page import="PresentationLayer.HTMLGenerator"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    if (request.getSession().getAttribute("user") != null) {
        Carport carport = (Carport) request.getSession().getAttribute("carport");
        Collection<List<Material>> listOfListsOfMaterials = carport.getListOfLists().values();
        HTMLGenerator html = new HTMLGenerator();

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carport</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="Ressources/Style.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="navigator.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <table class="table">
                        <%= html.getTableFromList(listOfListsOfMaterials)%>
                    </table>
                </div>
                <div class="col-md-6">
                    <jsp:include page="SVGcarport.jsp" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form action="FrontController" method="post">
                        <input type="hidden" name="command" value="pdf">
                        <input type="submit" value="Generate PDF">
                    </form>
                </div>
            </div>
        </div>
        <%
        } else {
        %> 
        <form id="1112" name="ChangeOrder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="demos">
        </form>
        <SCRIPT LANGUAGE="JavaScript">document.getElementById('1112').submit();</SCRIPT>
            <%
                }
            %>
    </body>
</html>

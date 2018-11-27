<%-- 
    Document   : navigator
    Created on : 14-11-2018, 10:57:06
    Author     : mwn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="heightandlength"> 
            <input type="submit" value="Go to calculator">
        </form>
        
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updatedatabase"> 
            <input type="submit" value="Edit products">
        </form>
        
        
    </body>
</html>

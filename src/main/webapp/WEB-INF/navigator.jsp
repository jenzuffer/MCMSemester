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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="Ressources/Style.css">
    </head>
    <body>
        
        <div class='container-fluid'>
            <div class="row" >
                <div class="header">
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="heightandlength"> 
                        <input type="submit" value="Go to calculator">
                    </form>
                </div>
                <div class="header">
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="gotocreateuser"> 
                        <input type="submit" value="Sign up">
                    </form>
                </div>
                <div class="header">
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="updatedatabase"> 
                        <input type="submit" value="Edit products">
                    </form>
                </div>
                 <div class="header">
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login"> 
                        <input type="submit" value="login">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

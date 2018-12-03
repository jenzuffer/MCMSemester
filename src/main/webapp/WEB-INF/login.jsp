<%-- 
    Document   : login
    Created on : Nov 30, 2018, 9:29:33 AM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <title>Login Page</title>
    </head>
    <body>
        <jsp:include page="navigator.jsp" />
        <form id="1112" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeepage">
            <div class='container'>
                <label>
                    <font size="+5"> 
                    Login
                    </font>
                    <br>
                    Fields with an  *  needs to be filled out.
                </label>
                <div class="row">
                    <div class='col-md-8'>
                        <div class="form-group"> 
                            <label>*Email</label>
                            <input type='email' name='email' class="form-control" placeholder='Enter your email..'>
                        </div>
                        <div class="form-group"> 
                            <label>*Enter a password</label>
                            <input pattern=".{8,}" type='password' name='firstpassword' class="form-control" placeholder='Enter an password..'
                                   required title="Password has to be atleast 8 characters long">
                        </div>
                        <button class="btn btn-primary" onclick="update()" >Login</button>
                    </div>
                    <div class="col-md-8"> 
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>

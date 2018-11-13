<%-- 
    Document   : ChangeOrder
    Created on : Nov 11, 2018, 4:51:45 PM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Order Modification</title>
    </head>
    <body>
        <div class="row">
            <div class="col-sm-12">
                <div class="text-center">
                    <div class="container"> 
                        <form id="1111" action="FrontController" method="POST" >'
                            Update an order
                            <input type="hidden" name="command" value="UpdateOrder"> 
                            <label for='height'> <b>Height </b>
                            </label>
                            <input type="number" placeholder="Enter Height" name="height" required="" >
                            <label for='width'> <b>Width </b>
                            </label>
                            <input type="number" placeholder="Enter Width" name="width" required="">
                            <label for='length'> <b>Length </b>
                            </label>
                            <input type="number" placeholder="Enter Length" name="length" required="">
                            <label for='polls'> <b>Polls </b>
                            </label>
                            <input type="number" placeholder="Enter Polls" name="polls" required="">
                            <label for='spears'> <b>Spears </b>
                            </label>
                            <input type="number" placeholder="Enter rafter" name="rafter" required="">
                            <button class="btn btn-primary" onclick="update()" > Submit </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            Function update()
            {
                document.getElementById('1111').submit();
            }
        </script>
    </body>
</html>

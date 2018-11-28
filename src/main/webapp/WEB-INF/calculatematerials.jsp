<%-- 
    Document   : ChangeOrder
    Created on : Nov 11, 2018, 4:51:45 PM
    Author     : Christian
--%>

<%@page import="PresentationLayer.HTMLGenerator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Integer> width = (List<Integer>) request.getAttribute("width");
    List<Integer> length = (List<Integer>) request.getAttribute("length");
    List<Integer> shedWidth = (List<Integer>) request.getAttribute("shedwidth");
    List<Integer> shedLength = (List<Integer>) request.getAttribute("shedlength");
    HTMLGenerator html = new HTMLGenerator();
%>

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
        <title>Order Modification</title>
    </head>
    <body>
        <jsp:include page="navigator.jsp" />
        <div class="text-center">
            <h3 class="header">Calculate Materials for an Order</h3>
            <hr>
        </div>
        <form id="1111" action="FrontController" method="post">
            <div class="container"> 
                <div class="row">
                    <div class="col-md-4">
                        <h5 class="second-header">Carport</h5>
                        <h6 class="second-header">Width</h6>
                        <select class="select-option" name="width">
                            <option>Choose width</option>
                            <%= html.getDropdownFromList(width, " cm")%>
                        </select>
                        <h6 class="second-header">Length</h6>
                        <select class="select-option" name="length">
                            <option>Choose length</option>
                            <%= html.getDropdownFromList(length, " cm")%>
                        </select>
                        <hr>
                        <h5 class="second-header">Valg af tag</h5>
                        <div>
                            <table>
                                <tr>
                                    <td>
                                        <input type='radio' name="chosenroof" value="False"> Fladt tag
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type='radio' name="chosenroof" value="True"> Højrest tag
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-md-6">
                                <h5 class="second-header">Shed</h5>
                            </div>
                            <div class="col-md-6" style="padding-top: 10px">
                                <label class="switch">
                                    <input id="toggle-shed-btn" type="checkbox" unchecked>
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </div>
                        <div class="shed-form" style="display: none">
                            <h6 class="second-header">Width</h6>
                            <select class="select-option" name="shedwidth">
                                <option>Choose width</option>
                                <%= html.getDropdownFromList(shedWidth, " cm")%>
                            </select>
                            <h6 class="second-header">Length</h6>
                            <select class="select-option" name="shedlength">
                                <option>Choose length</option>
                                <%= html.getDropdownFromList(shedLength, " cm")%>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" name="name" class="form-control" placeholder="Enter name">
                        </div>
                        <div class="form-group">
                            <label>Address</label>
                            <input type="text" name="address" class="form-control" placeholder="Enter address">
                        </div>
                        <div class="form-group">
                            <label>City</label>
                            <input type="text" name="city" class="form-control" placeholder="Enter city">
                        </div>
                        <div class="form-group">
                            <label>Phonenumber</label>
                            <input type="tel" name="pnumber" class="form-control" placeholder="Enter phonenumber">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" name="email" class="form-control" placeholder="Enter email">
                        </div>
                    </div>
                </div>
                <div class="col-md-12" style="padding-top: 20px">
                    <button class="btn btn-primary" onclick="update()" >Send inquiry</button>        
                </div>
                <input type="hidden" name="command" value="calculateorder">
            </div>
        </form>
        <form action="FrontController" method="post">
            <input type="hidden" name="width" value="600">
            <input type="hidden" name="length" value="780">
            <input type="hidden" name="shedwidth" value="530">
            <input type="hidden" name="shedlength" value="210">
            <input type="hidden" name="command" value="calculateorder">
            <input type="submit" value="Fog carport">
        </form>
        <script type="text/javascript">
            Function update() {
                document.getElementById('1111').submit();
            }
        </script>
        <script>
            $(document).ready(function () {

                $("#shed-form").hide();

                $("#toggle-shed-btn").click(function () {
                    $(".shed-form").slideToggle();
                });
            });
        </script>
    </body>
</html>

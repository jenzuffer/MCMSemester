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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <title>Detailed Order</title>
        <% Order order = (Order) request.getAttribute("order");%>
    </head>
    <body>
        <jsp:include page="navigator.jsp" />
        <div class="container">
            <form action="FrontController" method="post">
                <div class="row" style="margin-top: 20px">
                    <div class="col-md-6">
                        <div class="form-group">
                            <h5>Customer Info</h5>
                            <label>Customer Name</label>
                            <input type="text" class="form-control" name="name" value="<%= order.getName()%>" placeholder="Enter Customername">
                            <label>Customer Address</label>
                            <input type="text" class="form-control" name="adress" value="<%= order.getAdress()%>" placeholder="Enter Customer Address">
                            <label>Customer City</label>
                            <input type="text" class="form-control" name="city" value="<%= order.getCity()%>" placeholder="Enter Customer City">
                            <label>Customer Phonenumber</label>
                            <input type="tel" class="form-control" name="phone" value="<%= order.getPhoneNumber()%>" placeholder="Enter Customer Phonenumber">
                            <label>Customer Email</label>
                            <input type="email" class="form-control" name="email" value="<%= order.getEmail()%>" placeholder="Enter Customer Email">
                            <label>Role</label>
                            <input type="text" class="form-control" name="role" value="<%= order.getRole()%>" placeholder="Enter Role">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <h5>Carport Info</h5>
                            <label>Length</label>
                            <input type="number" class="form-control" name="length" value="<%= order.getLength()%>" placeholder="Enter Carport Length">
                            <label>Width</label>
                            <input type="number" class="form-control" name="width" value="<%= order.getWidth()%>" placeholder="Enter Carport Width">
                            <label>Shed Lenght</label>
                            <input type="number" class="form-control" name="shedlength" value="<%= order.getShedLength()%>" placeholder="Enter Shed Length">
                            <label>Shed Width</label>
                            <input type="number" class="form-control" name="shedwidth" value="<%= order.getShedWidth()%>" placeholder="Enter Shed Width">
                            <label>Roof</label>
                            <input type="text" class="form-control" name="roof" value="<%= order.isRoof()%>" placeholder="Enter Roof Type">
                            <label>Shed</label>
                            <input type="text" class="form-control" name="shed" value="<%= order.isShed()%>" placeholder="Enter Shed">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <button type="submit" class="btn btn-secondary" name="submit" value="Edit Order"><i class="fas fa-pen"></i> Update Order</button>
                            <button type="submit" class="btn btn-secondary" style="margin-left: 15px" name="submit" value="View Order content"><i class="fas fa-list-ul"></i> View Content</button>
                            <button type="submit" class="btn btn-secondary" style="margin-left: 15px" name="submit" value="pdfview"><i class="fas fa-file-pdf"></i> View PDF</button>
                            <button type="submit" class="btn btn-secondary" style="margin-left: 15px" name="submit" value="Send confirmation"><i class="far fa-envelope"></i> Send Confirmation</button>
                        </div>
                    </div>
                    <input type="hidden" name="OrderID" value="<%=order.getOrderID()%>">
                    <input type="hidden" name="customerid" value="<%=order.getCustomerID()%>">
                    <input type="hidden" name="carportid" value="<%=order.getCarportID()%>">
                    <input type="hidden" name="command" value="UpdateOrder">
                </div>
            </form>
        </div>
    </body>
</html>

<%-- 
    Document   : error
    Created on : Nov 11, 2018, 7:11:21 PM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error Page</title>
    </head>
    <body>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
    </body>
</html>

<%-- 
    Document   : SWGworkshop
    Created on : 19-Nov-2018, 08:32:21
    Author     : Mark
--%>

<%@page import="FunctionLayer.Carport"%>
<%@page import="PresentationLayer.SVGofCarport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SVG workshop</title>
    </head>
    <body>

        <%
            
            Carport carport = (Carport) request.getSession().getAttribute("carport");
        %>
        
        
        <%= new SVGofCarport().carport(carport)%>
    </body>
</html>

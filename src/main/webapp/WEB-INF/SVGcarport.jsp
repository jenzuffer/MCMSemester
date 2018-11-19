<%-- 
    Document   : SWGworkshop
    Created on : 19-Nov-2018, 08:32:21
    Author     : Mark
--%>

<%@page import="FunctionLayer.CarportDimensioner"%>
<%@page import="PresentationLayer.SVGofCarport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SWG workshop</title>
    </head>
    <body>

        <SVG width="127" height="127" viewbox="0 0 255 255">
        <rect x="0" y="0" height="255" width="255" style="stroke:#000000; fill: #ffffff"/>
        <circle cx="63.75" cy="63.75" r="63.75" stroke="black" stroke-width="3" fill="white" />
        <circle cx="191.25" cy="63.75" r="63.75" stroke="black" stroke-width="3" fill="white" />
        <circle cx="63.75" cy="191.25" r="63.75" stroke="black" stroke-width="3" fill="white" />
        <circle cx="191.25" cy="191.25" r="63.75" stroke="black" stroke-width="3" fill="white" />
        </SVG>

        <SVG width="25%" viewBox="0 0 150 40">
        <defs>
    <marker id="beginArrow" 
            markerWidth="9" markerHeight="9" 
            refX="1" refY="4"
            orient="auto">
        <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
    </marker>
    <marker id="endArrow" 
            markerWidth="9" markerHeight="9" 
            refX="8" refY="4" 
            orient="auto">
        <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
    </marker>
    </defs>
    <line x1="130"  y1="10" x2="12"   y2="35" 
          style="stroke:#006600;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    </SVG>


    <!--
    
            skaf caportens dimensions og brug dem til skalering af viewboxen?
    
            <SVG width="75%"
                 viewBox="0 0 <%=100%> <%=100%>">
    <%
        SVGofCarport svg = new SVGofCarport();
        svg.initSVGOfCarport(0 /*svgDimensionX*/, 0 /*svgDimensionY*/, (CarportDimensioner) request.getAttribute("carport"));
    %>
    </SVG>
    -->

</body>
</html>

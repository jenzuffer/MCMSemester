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
        <title>SVG workshop</title>
    </head>
    <body>

        <%
            SVGofCarport svg = new SVGofCarport();
            CarportDimensioner carport = (CarportDimensioner) request.getAttribute("carport");
        %>
        
        <svg width="<%=carport.getLength()%>" height="<%=carport.getWidth()%>" viewbox="0 0 <%=carport.getLength()+50%> <%=carport.getWidth()+50%>">
            <defs>
                <marker id="beginArrow" markerWidth="9" markerHeight="9" refX="1" refY="4" orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
                </marker>
                <marker id="endArrow" markerWidth="9" markerHeight="9" refX="8" refY="4" orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
                </marker>
            </defs>
            <rect x='30' y='30' width='<%=carport.getLength()%>' height='<%=carport.getWidth()%>' style="stroke:#000000; fill:#ffffff;"/>";
            
            <text x="<%=carport.getLength()/2%>" y="20" font-family="sans-serif" font-size="15px" text-anchor="center" fill="black">
                <%=carport.getLength()%>
            </text>
            
            <text x="-20" y="<%=carport.getWidth()/2 +20%>" font-family="sans-serif" font-size="15px" text-anchor="center" fill="black">
                <%=carport.getWidth()%>
            </text>
            
            <line label="test" x1="30"  y1="20"     x2="<%=carport.getLength()+30%>" y2="20" style="stroke:#006600;
                  marker-start: url(#beginArrow); 
                  marker-end: url(#endArrow);"/>
            <line label="test" x1="20"  y1="30"     x2="20" y2="<%=carport.getWidth()+30%>" style="stroke:#006600;
                  marker-start: url(#beginArrow); 
                  marker-end: url(#endArrow);"/>
            
        </svg>

</body>
</html>

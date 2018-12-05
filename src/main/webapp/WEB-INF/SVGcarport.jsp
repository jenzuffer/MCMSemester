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
            //SVGofCarport svg = (SVGofCarport) request.getSession().getAttribute("carport");
            int width = carport.getWidth();
            int length = carport.getLength();
        %>

        <svg width="100%" height="100%" viewbox="0 0 <%=length + 100%> <%=width + 100%>">
            <defs>
                <marker id="beginArrow" markerWidth="9" markerHeight="9" refX="1" refY="4" orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
                </marker>
                <marker id="endArrow" markerWidth="9" markerHeight="9" refX="8" refY="4" orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
                </marker>
            </defs>

            
            <%=new SVGofCarport().carport(carport) %>
            
            <!-- 
            <rect x='0' y='0' width='100%' height='100%' style="stroke:#000000; fill:#ffffff;"/>";
            <rect x='50' y='50' width='<%=length%>' height='<%=width%>' style="stroke:#000000; fill:#ffffff;"/>";
            -->



            <text x="<%=length / 2%>" 
                  y="40" 
                  font-family="sans-serif" 
                  font-size="15px" 
                  text-anchor="center" 
                  fill="black"> 
            Length: <%=length%> 
            </text>
            <text x="5" 
                  y="<%=width / 2 + 40%>" 
                  font-family="sans-serif" 
                  font-size="15px" 
                  text-anchor="center" 
                  fill="black">
            Width: <%=width%>
            </text>


            <line label="test" 
                  x1="50"  y1="20"     
                  x2="<%=length + 50%>" y2="20" 
                  style="stroke:#006600;
                  marker-start: url(#beginArrow); 
                  marker-end: url(#endArrow);"/>
            <line label="test" 
                  x1="20"  y1="50"     
                  x2="20" y2="<%=width + 50%>" 
                  style="stroke:#006600;
                  marker-start: url(#beginArrow); 
                  marker-end: url(#endArrow);"/>
        </svg>
    </body>
</html>

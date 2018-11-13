<%-- 
    Document   : index
    Created on : Nov 11, 2018, 5:31:28 PM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="ChangeOrder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="heightandLength">
        </form>
        <SCRIPT LANGUAGE="JavaScript">document.forms[0].submit();</SCRIPT>
    </body>
</html>

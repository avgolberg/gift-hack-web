<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3> List: <%= request.getAttribute("listName") %></h3> <br/>
        <h3> Author: <%= request.getAttribute("authorName") %></h3> <br/>
    </body>
</html>

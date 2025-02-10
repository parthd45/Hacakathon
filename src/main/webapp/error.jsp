<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Something went wrong!</h1>
    <p><%= request.getParameter("message") %></p>
    <a href="index.jsp">Go Back</a>
</body>
</html>

<%@ page import="java.util.List" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>Friends</title>
</head>
<body>
<div>
    <%
        List<String> names = (List<String>) request.getAttribute("friendsNames");
        if (names != null && !names.isEmpty()) {
            out.println("</ui>");
            for (String s : names) {
                out.println("<li>" + s + "</li>");
            }
            out.println("<li>");
        } else out.println("<p>There are no friend yet!</p>");
    %>
</div>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
<?xml version="1.0" encoding="UTF-8"?>
<!--
Created by IntelliJ IDEA.
User: alisaev
Date: 30.09.2020
Time: 16:15
-->
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
<head>
    <title>Delete friend</title>
</head>
<body>
<div>
    <%
        if (request.getAttribute("friendName") != null) {
            out.println("<p>Friend " + request.getAttribute("friendName") + " deleted!</p>");
        }
    %>
</div>
<div>
    <form method="post">
        <label>Name:
            <input type="text" name="name"><br/>
        </label>
        <button type="submit">Submit</button>
    </form>
</div>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
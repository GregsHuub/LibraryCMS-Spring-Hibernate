<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Main Category management panel</title>
    <style type="text/css">
        .divAdd, .divDelete, .divEdit {
            border: 2px solid black;
            background-color: lightcoral;
            width: 500px;

        }



    </style>
</head>

<body>
<h1>Tell me what you want to do bro</h1>
<div class="divAdd">
<a href="http://localhost:8080/api/category/showAll">Show me all Categories</a>
<%--uywac tego rodzaju inputow, do dynamicznego wysylania --%>
</div>
<br>
<div class="divDelete">
<form method="post" action="/api/category/delete">
    ID of Category to be removed: <input type="text" name="id"><br>
    <input type="submit" value="Submit">
</form>
</div>
<br>
<div class="divEdit">
<form method="post" action="/api/category/edit">
    ID of Category to edit <input type="text" name="id"><br>
    <input type="submit" value="Submit">
</form>
</div>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<form:form method="post" action="/api/category/editCategoryPost" modelAttribute="category">
    <form:hidden path="id"/> <br>
<%--&lt;%&ndash;    ID pozycji: tutaj wpisac samo ID ktore ma byc edytowane&ndash;%&gt;--%>
    ID to Edit: ${id}<br><br>
    Description: <br><form:textarea path="description"/><br>
    Name<br><form:input path="name"/><br>
    <input type="submit" value="Save">
</form:form>




</body>
</html>

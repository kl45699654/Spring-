<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Document</title>
</head>
<body><%--
<form action="result" method="get">
    名字
    <input type="text" name="name"><br>
    年龄
    <input type="number" name="age">
    <input type="submit">
</form>--%>
<form:form action="result" method="post" modelAttribute="user">
名字：<form:input path="name"/>
年龄：<form:input path="age"/>
    <input type="submit">
</form:form>
</body>
</html>
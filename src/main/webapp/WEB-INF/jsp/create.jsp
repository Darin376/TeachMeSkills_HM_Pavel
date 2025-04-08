<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create</h1>

<form action="${pageContext.request.contextPath}/hello/create" method="post">
    name:
    <input name="name">
    age:
    <input name="age">
    <button type="submit"> Submit</button>
</form>
</body>
</html>

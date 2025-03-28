<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <!-- Включаем EL, если она отключена -->
<html>
<head>
    <title>User Information</title>
</head>
<body>
<h1>ERROR ${error}</h1>

<p>Вернуться назад </p>
<form action="${pageContext.request.contextPath}/start" method="get">
    <button type="submit">Submit</button>
</form>
</body>
</html>

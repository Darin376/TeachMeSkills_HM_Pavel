<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <!-- Включаем EL, если она отключена -->
<html>
<head>
  <title>User Information</title>
</head>
<body>
<h1>User Information by id ${id}</h1>
<p>${first_name}</p> <!-- Используем EL -->
<p>You age: ${last_name}</p>
<p>You age: ${age}</p>
<p>You id: ${id}</p>

<p>Вернуться назад </p>
<form action="${pageContext.request.contextPath}/start" method="get">
  <button type="submit">Submit</button>
</form>
</body>
</html>

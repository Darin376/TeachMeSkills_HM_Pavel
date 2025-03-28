<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <!-- Включаем EL, если она отключена -->
<html>
<head>
    <title>User Information</title>
</head>
<body>
<h1>User Information</h1>
<p>Hello: ${name}</p> <!-- Используем EL -->
<p>You age: ${age}</p>

<p>Показать всех юзеров  удалить , создать , изменить выбранных </p>

<form action="${pageContext.request.contextPath}/show-user" method="get">
    <button type="submit">SHOW ALL User</button>
</form>

<p>Введите id ользователья которого хотите узнать </p>

<form action="${pageContext.request.contextPath}/get-user" method="get">
    <input type="number" name="id" placeholder="id user" required />
    <button type="submit">Submit</button>
</form>

<%--<p> Создайте пользоваетеля </p>--%>

<%--<form action="${pageContext.request.contextPath}/create-user" method="post">--%>
<%--    <input type="text" name="first_name" placeholder="First_Name" required>--%>
<%--    <input type="text" name="last_name" placeholder="Last_name" required>--%>
<%--    <input type="number" name="age" placeholder="age user" required />--%>
<%--    <button type="submit">Create</button>--%>
<%--</form>--%>

<%--<p> Удалить юзера по ID</p>--%>

<%--<form action="${pageContext.request.contextPath}/delete-user" method="post">--%>
<%--    <input type="number" name="ID" placeholder="ID user" required />--%>
<%--    <button type="submit">Delete User ID</button>--%>
<%--</form>--%>

<h2>${noUserInfo}</h2>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>



<html>
<head>
  <title>Список пользователей</title>
</head>
<body>
<h1>Список пользователей</h1>
<h1>Список пользователей</h1>
<c:if test="${empty all_users}">
  <p>Список пользователей пуст.</p>
</c:if>
<c:if test="${not empty all_users}">
  <table border="1">
    <tr>
      <th>Имя</th>
      <th>Фамилия</th>
      <th>Возраст</th>
      <th>ID</th>
      <th>Удалить пользователя</th>
      <th>Введите другое имя для изменения имени пользователя </th>
    </tr>
    <c:forEach var="user" items="${all_users}">
      <tr>
        <td>${user.first_name}</td>
        <td>${user.last_name}</td>
        <td>${user.age}</td>
        <td>${user.id}</td>
        <td>
  <form action="${pageContext.request.contextPath}/delete-user" method="post">
    <input type="hidden" name="id" value="${user.id}" />
    <button type="submit">Delete</button>
  </form>
        </td>
        <td>
          <form action="${pageContext.request.contextPath}/update-user" method="post">
            <input type="hidden" name="id" value="${user.id}" />
            <input type="text" name="newName" required />
            <button type="submit">Изменить</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<p> Создайте пользоваетеля </p>

<form action="${pageContext.request.contextPath}/create-user" method="post">
  <input type="text" name="first_name" placeholder="First_Name" required>
  <input type="text" name="last_name" placeholder="Last_name" required>
  <input type="number" name="age" placeholder="age user" required />
  <button type="submit">Create</button>
</form>

<p>Вернуться назад </p>
<form action="${pageContext.request.contextPath}/start" method="get">
  <button type="submit">Submit</button>
</form>

</body>
</html>
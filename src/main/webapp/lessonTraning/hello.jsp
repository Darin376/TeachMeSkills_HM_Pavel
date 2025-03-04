
<%--<%@taglib prefix="fmt" uri="http://jakarta.apache.org/taglibs/standard/scriptfree" %>--%>
<%--<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/functions" %>--%>


<%--JSTL--%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello</title>
</head>
    <body>


    <c:forEach var="user" items="${users}">
        <li> ${user} da da daaa</li>
        <li><c:out value="${user}"/></li>
    </c:forEach>

    <c:if test="${isVisible}">
<%--    <c:if test="${!isVisible || true && false }">--%>
<%--    <c:if test="${ not isVisible and true or false}">--%>
         <p>visible</p>
    </c:if>


<%--    if else--%>
<c:choose>
    <c:when test="${val==1}">
        <p>equals 1</p>
    </c:when>
    <c:when test="${val==2}">
        <p>equals 2</p>
    </c:when>
     <c:otherwise>
         <p> UndeFined</p>
     </c:otherwise>
</c:choose>
    <%--    if else--%>




<%--    создание переменных 1 JSTL --%>
    <c:set var="user" value="Pavel"/>
    <c:set var="user3">
        alert("hello");
    </c:set>

    <c:out value="${user3}"/>
    <%--    создание переменных 2  скверлет--%>
    <%
        String user2 = "Pavel";
    %>
    <%--скверлет--%>
    Today <%=new java.util.Date()%>

    <h1>name:${name}</h1>
    <h3>str:${str}</h3>
    <br>
    <h4>strList:${strList}</h4>
    <h4>strList:${strList[0 ]}</h4>
    <%
    for(int i=0;i<10;i++){

        out.print("Hello"+ i);
    }
    %>
    <p> Name    <%=request.getParameter("nameInput")%></p>
    <p> Name    <%=request.getParameter("ageInput")%></p>

<%--    <form action="${pageContext.request.contextPath}/good-Servlet" method="post">--%>
<%--    <form action="/hello.jsp" method="post">--%>
    <form action="${pageContext.request.contextPath}/good-Servlet" method="post">
        <input  name="nameInput" placeholder="Name"/>
        <input  name="ageInput" placeholder="Age"/>
        <button type="submit">Submit</button>
    </form>
    </body>
</html>
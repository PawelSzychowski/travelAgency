<%@ page import="javagda21.model.Continent" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj Kraj</title>
</head>
<body>
<h2>Dodaj Kraj</h2>
<jsp:include page="header.jsp"></jsp:include>

<form action="/country/add" method="post">
    <input type="text" name="name">
    <select name="continent">
        <%
            for(Continent s: Continent.values()){%>
        <option value="<%=s%>"><%=s%></option>
        <%
            }
        %>
        <input type="submit">
    </select>

</form>
</body>
</html>

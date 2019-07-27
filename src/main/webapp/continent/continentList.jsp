<%@ page import="javagda21.model.Continent" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Kontynentów</title>
</head>
<body>
<h2>Lista Kontynentów</h2>
<jsp:include page="/header.jsp"></jsp:include>
<%
    for(Continent s: Continent.values()) {
        out.println(s);
        out.println("</br>");
    }
%>


</body>
</html>

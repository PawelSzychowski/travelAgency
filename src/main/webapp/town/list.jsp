<%@ page import="javagda21.model.Town" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Miast</title>
</head>
<body>
<h2>List krajów</h2>
<jsp:include page="header.jsp"></jsp:include>
<table>
    <tr>
        <th style="width: 150px">Miasto</th>
        <th style="width: 150px">Kraj</th>
        <th style="width: 150px">usun</th>
    </tr>
    <%
        List<Town> townList = (List<Town>) request.getAttribute("townList");
        for (Town t : townList) {
            out.println("<tr>");
            out.println("<td>" + t.getNazwa() + "</td>");
            out.println("<td>" + t.getCountry().getNazwa() + "</td>");
            out.print("<td>" + "<a href=\"/town/remove?id=" + t.getId() + "\">" + "usun</a>" + "</td>");
            out.println("</tr>");
        }

    %>
</table>
</body>
</html>

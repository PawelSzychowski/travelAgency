<%@ page import="javagda21.model.Country" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country List</title>
</head>
<body>
<h2>List krajów</h2>
<jsp:include page="header.jsp"></jsp:include>
<table>
    <tr>
        <th style="width: 150px">nazwa</th>
        <th style="width: 150px">Kontynent</th>
        <th style="width: 150px">usun</th>
    </tr>
    <%
        List<Country> country = (List<Country>) request.getAttribute("country");
        for (Country s : country) {
            out.println("<tr>");
            out.println("<td>" + s.getNazwa() + "</td>");
            out.println("<td>" + s.getContinent() + "</td>");
            out.print("<td>" + "<a href=\"/country/remove?id=" + s.getId() + "\">" + "usun</a>" + "</td>");
            out.println("</tr>");
        }

    %>
</table>
</body>
</html>

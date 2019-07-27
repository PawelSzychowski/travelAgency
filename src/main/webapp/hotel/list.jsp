<%@ page import="javagda21.model.Hotel" %>
<%@ page import="java.util.List" %>
<%@ page import="javagda21.model.Town" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Hoteli</title>
</head>
<body>
<h2>List krajów</h2>
<jsp:include page="header.jsp"></jsp:include>
<table>
    <tr>
        <th style="width: 150px">Nazwa Hotelu</th>
        <th style="width: 150px">Opis</th>
        <th style="width: 150px">ilosc gwiazdek</th>
        <th style="width: 150px">Miasto</th>
        <th style="width: 150px">Państwo</th>
        <th style="width: 150px">usuń</th>
    </tr>
        <%
        List<Hotel> hotelList = (List<Hotel>) request.getAttribute("hotelList");
        for (Hotel h : hotelList) {
            out.println("<tr>");
            out.println("<td>" + h.getName() + "</td>");
            out.println("<td>" + h.getDiscription() + "</td>");
            out.println("<td>" + h.getStandard() + "</td>");
            out.println("<td>" + h.getTown().getNazwa() + "</td>");
            out.println("<td>" + h.getTown().getCountry().getNazwa() + "</td>");

            out.print("<td>" + "<a href=\"/hotel/remove?id=" + h.getId() + "\">" + "usun</a>" + "</td>");
            out.println("</tr>");
        }

    %>

</body>
</html>

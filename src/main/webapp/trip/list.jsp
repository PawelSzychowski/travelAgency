<%@ page import="javagda21.model.Trip" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wycieczki</title>
</head>
<body>
<h2>Wycieczki</h2>
<jsp:include page="header.jsp"></jsp:include>
<table>
    <tr>
        <th style="width: 150px">Miejsce</th>
        <th style="width: 150px">nazwa hotelu</th>
        <th style="width: 150px">ilosc gwiazdek</th>
        <th style="width: 150px">usun</th>
        <th style="width: 150px">detale</th>
    </tr>
        <%
        List<Trip> tripList = (List<Trip>) request.getAttribute("tripList");
        for (Trip t : tripList) {
            out.println("<tr>");
            out.println("<td>" + t.getTo().getNazwa() + "</td>");
            out.println("<td>" + t.getHotel().getName() + "</td>");
            out.println("<td>" + t.getHotel().getStandard() + "</td>");
            out.print("<td>" + "<a href=\"/trip/remove?id=" + t.getId() + "\">" + "usun</a>" + "</td>");
            out.print("<td>" + "<a href=\"/trip/detalis?id=" + t.getId() + "\">" + "detale</a>" + "</td>");
            out.println("</tr>");
        }

    %>

</body>
</html>

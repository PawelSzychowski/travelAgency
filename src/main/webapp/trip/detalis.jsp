<%@ page import="javagda21.model.Trip" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegułu</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<table>
    <tr>
        <th style="width: 150px">Nazwa hotelu</th>
        <th style="width: 150px">ilosc gwiazdek</th>
        <th style="width: 150px">Opis hoelu</th>
        <th style="width: 150px">data odlotu</th>
        <th style="width: 150px">Data przylotu</th>
        <th style="width: 150px">Miasto docelowe</th>
        <th style="width: 150px">Miasto wylotu</th>
        <th style="width: 150px">ilosc miejsc dla doroslych</th>
        <th style="width: 150px">ilosc miejsc dla dzieci</th>

    </tr>
        <%
         Optional<Trip> trip = (Optional<Trip>) request.getAttribute("trip");
            out.println("<tr>");
            out.println("<td>" + trip.get().getHotel().getName() + "</td>");
            out.println("<td>" + trip.get().getHotel().getStandard() + "</td>");
            out.println("<td>" + trip.get().getHotel().getDiscription() + "</td>");
            out.println("<td>" + trip.get().getDateOfArrive() + "</td>");
            out.println("<td>" + trip.get().getDateOfDeparture() + "</td>");
            out.println("<td>" + trip.get().getTo().getNazwa() + "</td>");
            out.println("<td>" + trip.get().getFrom().getNazwa() + "</td>");
            out.println("<td>" + trip.get().getAvibleSitsForAdult() + "</td>");
            out.println("<td>" + trip.get().getAvibleSitesForKids() + "</td>");


            out.println("</tr>");

    %>

</body>
</html>

<%@ page import="javagda21.model.Town" %>
<%@ page import="java.util.List" %>
<%@ page import="javagda21.model.Hotel" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dodaj Wycieczke</h2>
<jsp:include page="header.jsp"></jsp:include>

<form action="/trip/add" method="post">
     Data wylotu<input type="date" name="dateOfDeparture">
    </br>
    Data Powrotu <input type="date" name="dateOfArrive">
    </br>
    miasto Docelowe <select name="townTo">
    </br>
    <%
        List<Town> townList = (List<Town>) request.getAttribute("townList");
        for (Town t : townList) {
            out.println("<option value=\"" + t.getId()+  "\">" + t.getNazwa() + "</option>");
        }

    %>
</select>
    </br>
    Miasto Wylotu <select name="townFrom">
    <%
        for (Town t : townList) {
            out.println("<option value=\"" + t.getId()+  "\">" + t.getNazwa() + "</option>");
        }

    %>
</select>
    </br>
    hotel <select name="hotel">
    <%
        List<Hotel> hotelList = (List<Hotel>) request.getAttribute("hotelList");
        for (Hotel h : hotelList) {
            out.println("<option value=\"" + h.getId()+  "\">" + h.getName() + "</option>");
        }

    %>
</select>
    </br>
    Promowane <input type="checkbox" name="promoted">
    </br>
    Miejsca dla dorosłych <input type="number" name="avibleSitsForAdult">
    </br>
    Miejsca dla dzieci <input type="number" name="avibleSitesForKids">
    </br>
    <input type="submit">

</form>
</body>
</html>

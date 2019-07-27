<%@ page import="javagda21.model.Town" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj Hotel</title>
</head>
<body>
<h2>Dodaj Miasto</h2>
<jsp:include page="header.jsp"></jsp:include>

<form action="/hotel/add" method="post">
   nazwa hotelu <input type="text" name="name">
</br>
   miasto <select name="town">
        <%
            List<Town> townList = (List<Town>) request.getAttribute("townList");
            for (Town t : townList) {
                out.println("<option value=\"" + t.getId()+  "\">" + t.getNazwa() + "</option>");
            }

        %>
</select>

    </br>
    ilosc gwiazdek <input type="text" name="standard">
    </br>
    opis <input type="text" name="discription">
    </br>
        <input type="submit">

</form>
</body>
</html>

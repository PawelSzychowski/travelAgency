<%@ page import="java.util.List" %>
<%@ page import="javagda21.model.Country" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-27
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj Miasto</title>
</head>
<body>
<h2>Dodaj Miasto</h2>
<jsp:include page="header.jsp"></jsp:include>

<form action="/town/add" method="post">
    <input type="text" name="name">
    <select name="country">
        <%
            List<Country> countryList = (List<Country>) request.getAttribute("countryList");
            for (Country country : countryList) {
                out.println("<option value=\"" + country.getId()+  "\">" + country.getNazwa() + "</option>");
            }

        %>
        <input type="submit">
    </select>

</form>
</body>
</html>

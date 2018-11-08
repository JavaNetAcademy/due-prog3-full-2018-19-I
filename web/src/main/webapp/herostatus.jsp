<%-- 
    Document   : herostatus
    Created on : 2018.11.08., 21:50:18
    Author     : Attila
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>A hősök jelenlegi státusza!</h1>
        <form action="/hoe/herostatus" method="get">
            <fieldset>
                <legend>Státuszok:</legend>
                <table border="1">
                    <tr>
                        <th><b>Hőd ID<b></th>
                        <th>Élet pontok</th>
                        <th>Mana pontok</th>
                        <th>Level</th>
                        <th>Exp</th>
                        <th>Int</th>
                        <th>Str</th>
                        <th>Agi</th>
                    </tr>
                    <c:forEach var="status" items="${herostatus}">
                        <tr>
                            <td>${status.heroid}</td>
                            <td>${status.health}</td>
                            <td>${status.mana}</td>
                            <td>${status.level}</td>
                            <td>${status.experience}</td>
                            <td>${status.intellect}</td>
                            <td>${status.strength}</td>
                            <td>${status.agility}</td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </form>
    </body>
</html>

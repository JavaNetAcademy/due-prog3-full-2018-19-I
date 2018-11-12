<%-- 
    Document   : resources
    Created on : Nov 9, 2018, 11:14:56 AM
    Author     : I-117-13.hallgato
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resources Page</title>
    </head>
    <body>
        <h1>Resources</h1>
        <table border="1">
            <tr>
                <th>Resources name</th>
                <th>Resources description</th>
                <th>REsources amount</th>
            </tr>
            <c:forEach var="resource" items="${resources}">
                <tr>
                    <td>${resource.nev}</td>
                    <td>${resource.info}</td>
                    <td>${resource.mennyiseg}</td>
                </tr>
            </c:forEach>
        </table>
        </br>
        <table>
            <tr>
                <td><form action="/hoe/user/resources/new" method="get"><input type="submit" value="New resources"></form></td>
                <td><form action="/hoe/user/resources/delresources" method="get"><input type="submit" value="Modify/delete resources"></form></td>
            </tr>
        </table>
    </body>
</html>

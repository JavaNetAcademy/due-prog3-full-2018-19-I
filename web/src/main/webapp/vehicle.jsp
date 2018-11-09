<%-- 
    Document   : vehicle
    Created on : 2018.11.08., 23:28:57
    Author     : ttama
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items Page</title>
    </head>
    <body>
        <h1>Vehicles</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Speed</th>
            </tr>
            <c:forEach var="vehicle" items="${vehicle}">
                <tr>
                    <td>${vehicle.id}</td>
                    <td>${vehicle.name}</td>
                    <td>${vehicle.info}</td>
                    <td>${vehicle.speed}</td>
                </tr>
            </c:forEach>
        </table>
        </br>
        <table>
            <tr>
                <td><form action="/hoe/newVehicle.jsp" method="post"><input type="submit" value="New vehicle"></form></td>
                <td><form action="/hoe/vehicleModification.jsp" method="get"><input type="submit" value="Modify/delete vehicle"></form></td>
            </tr>
        </table>
    </body>
</html>

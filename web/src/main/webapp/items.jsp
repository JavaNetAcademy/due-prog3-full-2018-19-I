<%-- 
    Document   : items
    Created on : 2018.11.08., 18:54:02
    Author     : thejumper203
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
        <h1>Belépve mint: <b> ${current.name}</b> </h1>
        <table border="1">
            <tr>
                <th>Item name</th>
                <th>Description</th>
                <th>Amount</th>
                <th>Nyersanyagid</th>
                
            </tr>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.nev}</td>
                    <td>${item.info}</td>
                    <td>${item.mennyiseg}</td>
                    <td>${item.nyersanyagid}</td>
               </tr>
            </c:forEach>
        </table>
        </br>
        <table>
            <tr>
                <td><form action="/hoe/user/items/new" method="get"><input type="submit" value="New item"></form></td>
                <td><form action="/hoe/user/items/delitem" method="get"><input type="submit" value="Modify/delete item"></form></td>
            </tr>
        </table>
    </body>
</html>

<%-- 
    Document   : armors
    Created on : 2018.11.13., 21:49:38
    Author     : Nagy Adam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Armor Page</title>
    </head>
    <body>
        <h1>Belépve mint: <b> ${current.name}</b> </h1>
        <table border="1">
            <tr>
                <th>Armor name</th>
                <th>Description</th>
                <th>Tamadoertek</th>
                 <th>Vedoertek</th>
                <th>Nyersanyagid</th>
                
            </tr>
            <c:forEach var="armor" items="${armors}">
                <tr>
                    <td>${armor.nev}</td>
                    <td>${armor.info}</td>
                    <td>${armor.tamadoertek}</td>
                    <td>${armor.vedoertek}</td>
                    <td>${armor.nyersanyagid}</td>
               </tr>
            </c:forEach>
        </table>
        </br>
        <table>
            <tr>
                <td><form action="/hoe/user/armor/newarmor" method="get"><input type="submit" value="New Armor"></form></td>
                <td><form action="/hoe/user/armor/delarmor" method="get"><input type="submit" value="Modify/delete armor"></form></td>
            </tr>
        </table>
    </body>
</html>


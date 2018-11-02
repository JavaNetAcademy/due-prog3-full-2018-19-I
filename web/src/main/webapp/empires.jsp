<%-- 
    Document   : empires
    Created on : 2018.10.31., 21:14:23
    Author     : thejumper203
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
        <h1>Welcome ${user.name}!</h1>
        <h2>Empires</h2>
        <form action="/hoe/user/locations" method="post">
        <table>
            <tr>
                <td>Select empire:</td>
                <td>
                    <select id="selectedEmpire" name="selectedEmpire">
                        <c:forEach var="emp" items="${empires}">
                        <option value="${emp.id}">${emp.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" value="Select"</td>
            </tr>
        </table>
        </form>        
        <h2>Heroes</h2>
        <table border="1">
            <c:forEach var="hero" items="${heroes}">
                <tr>
                    <td><b>${hero.name}</b></td>
                    <td>${hero.description}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

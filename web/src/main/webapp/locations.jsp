<%-- 
    Document   : locations
    Created on : 2018.10.31., 22:40:18
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
        <h1>Locations in <u>${curremp.name}</u> (<i>level ${curremp.level}</i>)</h1>
        <h3><q><i>${curremp.description}</i></q></h3>
        <table border="1">
            <tr>
                <th>Location name</th>
                <th>Description</th>
            </tr>
            <c:forEach var="loc" items="${locations}">
                <tr>
                    <td>${loc.name}</td>
                    <td>${loc.desc}</td>
                </tr>
            </c:forEach>
        </table>
        </br>

        <form action="/hoe/user/locations/new" method="get">
            <div>
                <label>Create new location</label>
                <input type="submit" value="New location">
            </div>
        </form>
        </br>
        <form action="/hoe/user/locations/delmod" method="post">
            <table>
                <tr>
                    <td>
                    <select name="selectedLocation">
                        <c:forEach var="loc" items="${locations}">
                            <option value="${loc.id}">${loc.name}</option>
                        </c:forEach>
                    </select>
                    </td> 
                    <td>
                        <input type="submit" name="delete" value="Delete" onclick="return confirm('Are you sure you want to delete this location?')">
                    </td>
                </tr>
            </table>
            <fieldset>
                <legend>Modify selected location</legend>
                <div>
                    <label>New name: </label>
                    <input type="text" name="newname">
                </div>
                <div>
                    <label>New description: </label>
                    <input type="text" name="newdesc">
                </div>
                <div>
                    <input type="submit" name="modify" value="Modify" onclick="return confirm('Are you sure you want to modify this location?')">
                </div>
            </fieldset>
        </form>
    </body>
</html>

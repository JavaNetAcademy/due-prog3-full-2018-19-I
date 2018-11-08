<%-- 
    Document   : empire
    Created on : 2018.11.08., 20:27:15
    Author     : thejumper203
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage empires</title>
    </head>
    <body>
        <h1>Manage ${user.name}'s empires</h1>
        <table border="1">
            <tr>
                <th>Empire name</th>
                <th>Description</th>
                <th>Level</th>
            </tr>
                <c:forEach var="emp" items="${empires}">
                    <tr>
                        <td>${emp.name}</td>
                        <td>${emp.description}</td>
                        <td>${emp.level}</td>
                    </tr>
                </c:forEach>
        </table>
        </br>
        <form action="/hoe/user/empires/delmod" method="post">
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
            </tr>
        </table>
        </br>
        <fieldset>
            <legend>Modify selected empire</legend>
                <div>
                <label>New name:</label>
                <input type="text" name="newname">
                </div>
                <div>
                <label>New description:</label>
                <input type="text" name="newdesc">
                </div>
                <input type="submit" name="modify" value="Modify selected" onclick="return confirm('Are you sure?')">
        </fieldset>
        <fieldset>
            <legend>Delete selected empire</legend>
            <input type="submit" name="delete" value="Delete selected" onclick="return confirm('Are you sure?')">
        </fieldset>
        </form>  
        </br>
        <form action="/hoe/user/empires/new" method="post">
            <fieldset>
            <legend>Create new empire</legend>
                <div>
                    <label>Name:</label>
                    <input type="text" name="pname">
                </div>
                <div>
                    <label>Description:</label>
                    <input type="text" name="pdesc">
                </div>                
                <div>
                    <label>Level</label>
                    <input type="text" name="plevel">
                </div>
                <input type="submit" value="Add">
        </form>
        </fieldset>
    </body>
</html>

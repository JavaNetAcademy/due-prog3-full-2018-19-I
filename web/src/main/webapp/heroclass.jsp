<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Hero Class</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/hoe/addnewheroclass" method="post">
            <fieldset>
                <legend>New Hero Class </legend>
                <div>
                    <label>User ID: </label>
                    <input name="userid">
                </div>
                <div>
                    <label>Hero Class name: </label>
                    <input name="name">
                </div>
                <div>
                    <label>Description: </label>
                    <input name="description">
                </div>
                <div><input type="submit" value="Hozzáad"></div>
            </fieldset>
            <form action="/hoe/removeheroclass" method="post">
            <fieldset>
                <legend>Delete </legend>
                <div>
                    <label>Spell ID: </label>
                    <input name="id">
                </div>
                <div><input type="submit" value="Képesség törlése"></div>
            </fieldset>
        </form>
        <form action="/hoe/heroclass" method="get">
            <fieldset>
                <legend>All hero classes</legend>
                <table border="1">
                    <tr>
                        <th>Class ID</th>
                        <th>Class name</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach var="heroclass" items="${heroclasses}">
                        <tr>
                            <td>${heroclasses.id}</td>
                            <td>${heroclasses.name}</td>
                            <td>${heroclasses.description}</td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </form>
        </form>
    </body>
</html>

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
                    <label>Hero Class name: </label>
                    <input name="name">
                </div>
                <div>
                    <label>Description: </label>
                    <input name="description">
                </div>
                <div><input type="submit" value="Class Hozzáad"></div>
            </fieldset>
        </form>
        <form action="/hoe/removeheroclass" method="post">
            <fieldset>
                <legend>Delete </legend>
                <div>
                    <label>Hero Class name: </label>
                    <input name="classname">
                </div>
                <div><input type="submit" value="Class törlése"></div>
            </fieldset>
        </form>
        <form action="/heroclass" method="get">
            <fieldset>
                <legend>All hero classes</legend>
                <table border="1">
                    <tr>
                        <th>Class name</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach var="heroclass" items="${heroclasses}">
                        <tr>
                            <td>${heroclass.name}</td>
                            <td>${heroclass.description}</td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </form>
    </body>
</html>

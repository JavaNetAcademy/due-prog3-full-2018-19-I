<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>Create Spell</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/hoe/spellAdd" method="post">
            <fieldset>
                <legend>Új Spell </legend>
                <div>
                    <label>Hős ID: </label>
                    <input name="heroid">
                </div>
                <div>
                    <label>Spell név: </label>
                    <input name="name">
                </div>
                <div>
                    <label>Leírás: </label>
                    <input name="description">
                </div>
                <div>
                    <label>Támadó erő: </label>
                    <input name="attpower">
                </div>
                <div>
                    <label>Védekező erő: </label>
                    <input name="deffpower">
                </div>
                <div><input type="submit" value="Hozzáad"></div>
            </fieldset>
        </form>
        <form action="/hoe/spellRemove" method="post">
            <fieldset>
                <legend>Törlés </legend>
                <div>
                    <label>Spell ID: </label>
                    <input name="id">
                </div>
                <div><input type="submit" value="Képesség törlése"></div>
            </fieldset>
        </form>
        <form action="/hoe/spell" method="get">
            <fieldset>
                <legend>All spells</legend>
                <table border="1">
                    <tr>
                        <th>Spell ID</th>
                        <th>Spell neve</th>
                        <th>Leírás</th>
                    </tr>
                    <c:forEach var="spell" items="${spells}">
                        <tr>
                            <td>${spell.id}</td>
                            <td>${spell.name}</td>
                            <td>${spell.description}</td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </form>
        </body>

</html>

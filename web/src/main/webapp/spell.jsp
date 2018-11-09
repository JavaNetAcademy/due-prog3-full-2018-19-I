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
                    <label>Class: </label>
                    <input name="classidadd">
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
                        <th>ID</th>
                        <th><b>Class</b></th>
                        <th>Name</th>
                        <th>Leírás</th>
                        <th>Attack Power</th>
                        <th>Deffensive Power</th>
                    </tr>
                    <c:forEach var="spellall" items="${spellsAll}">
                        <tr>
                            <td>${spellall.id}</td>
                            <td>${spellall.classid}</td>
                            <td>${spellall.name}</td>
                            <td>${spellall.description}</td>
                            <td>${spellall.attpower}</td>
                            <td>${spellall.deffpower}</td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
            <fieldset>
                <legend>Specific class spells</legend>
                <div>
                    <label>Class: </label>
                    <input type="submit" name="selectid" value="Warrior">
                    <input type="submit" name="selectid" value="Paladin">
                </div>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th><b>Class</b></th>
                        <th>Name</th>
                        <th>Leírás</th>
                        <th>Attack Power</th>
                        <th>Deffensive Power</th>
                    </tr>
                    <c:forEach var="spell" items="${spellsSel}">
                        <tr>
                            <td>${spell.id}</td>
                            <td>${spell.classid}</td>
                            <td>${spell.name}</td>
                            <td>${spell.description}</td>
                            <td>${spell.attpower}</td>
                            <td>${spell.deffpower}</td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </form>
        </body>

</html>

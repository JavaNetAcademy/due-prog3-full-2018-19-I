<%-- 
    Document   : herostatus
    Created on : 2018.11.08., 21:50:18
    Author     : majermarci / Attila
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
        <h1>A hősök jelenlegi státusza!</h1>
        <form action="/hoe/herostatus" method="get">
            <fieldset>
                <legend><h1>Státuszok / megjelenítés / módosítása!</h1></legend>
                <table border="1">
                    <tr>
                        <th><b>Hőd ID<b></th>
                        <th>Élet pontok</th>
                        <th>Mana pontok</th>
                        <th>Level</th>
                        <th>Exp</th>
                        <th>Int</th>
                        <th>Str</th>
                        <th>Agi</th>
                    </tr>
                    <c:forEach var="status" items="${herostatus}">
                        <tr>
                            <td>${status.heroid}</td>
                            <td>${status.health}</td>
                            <td>${status.mana}</td>
                            <td>${status.level}</td>
                            <td>${status.experience}</td>
                            <td>${status.intellect}</td>
                            <td>${status.strength}</td>
                            <td>${status.agility}</td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </form>
        <form action="herostatusDelMod" method="post">
            <fieldset>
                <legend><h1>Státuszok módosítása!</h1></legend>
                <table border="1">
                    <tr>
                        <th><b>Hőd ID<b></th>
                        <th>Élet pontok</th>
                        <th>Mana pontok</th>
                        <th>Level</th>
                        <th>Exp</th>
                        <th>Int</th>
                        <th>Str</th>
                        <th>Agi</th>
                    </tr>
                        <tr>
                            <td>
                                <div>
                                    <input type="text" name="selectid" value="">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <input type="text" name="newhealth" value="">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <input type="text" name="newmana" value="">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <input type="text" name="newlevel" value="">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <input type="text" name="newexperience" value="">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <input type="text" name="newint" value="">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <input type="text" name="newstr" value="">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <input type="text" name="newagi" value="">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <input type="submit" name="modify" value="modify">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <input type="submit" name="delete" value="delete" disabled>
                                </div>
                            </td>
                        </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>

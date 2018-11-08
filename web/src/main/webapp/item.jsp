<%-- 
    Document   : item
    Author     : Nagy Adam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>Create Item</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/hoe/user/item/" method="post">
            <fieldset>
                <legend>Új Item </legend>
                <div>
                    <label>Item név: </label>
                    <input name="nev">
                </div>
                <div>
                    <label>Leírás: </label>
                    <input name="info">
                </div>
                <div>
                <label>Mennyiség: </label>
                <input name="mennyiseg">
                </div>
                <div><input type="submit" value="Hozzáad"></div>
            </fieldset>
        </form>
        <form action="/hoe/user/item" method="post">
            <fieldset>
            <table>
                <tr>
                    <td>
                    <select name="selectedItem">
                        <c:forEach var="ite" items="${items}">
                            <option value="${ite.id}">${ite.name}</option>
                        </c:forEach>
                    </select>
                    </td> 
                    <td>
                        <input type="submit" name="delete" value="Delete" onclick="return confirm('Are you sure you want to delete this Item?')">
                    </td>
                </tr>
            </table>
            </fieldset>
           </form>
        </body>
</html>

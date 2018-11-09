<%-- 
    Document   : newitem
    Created on : 2018.11.08., 16:11:49
    Author     : Nagy Adam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Új item</title>
    </head>
    <body>
     <form action="/hoe/user/items/new" method="post">
            <fieldset>
                <legend>Új Item</legend>
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
                <input type="number" min="0" name="mennyiseg" >
                </div>
                <select name="selectedItem">
                <c:forEach var="it" items="${resources}">
                    <option value="${it.id}">${it.nev}</option>
                </c:forEach>
            </select> 
                <div><input type="submit" value="Hozzáad" onclick="Szamot()"></div>
            </fieldset>
     </form>
       
    </body>
</html>

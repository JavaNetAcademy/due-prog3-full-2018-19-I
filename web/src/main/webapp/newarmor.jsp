<%-- 
    Document   : newarmor
    Created on : 2018.11.13., 21:50:28
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
     <form action="/hoe/user/armor/newarmor" method="post">
            <fieldset>
                <legend>Új Item hozzáadása ${current.name} felshasználó eszköztárához.</legend>
                <div>
                    <label>Item név: </label>
                    <input name="nev">
                </div>
                <div>
                    <label>Leírás: </label>
                    <input name="info">
                </div>
                <div>
                <label>Tamadoertek: </label>
                <input type="number" min="0" name="tamadoertek" >
                </div>
                <div>
                <label>Vedoertek: </label>
                <input type="number" min="0" name="vedoertek" >
                </div>
                <select name="nyersanyag">
                <c:forEach var="ar" items="${resources}">
                    <option value="${ar.id}">${ar.nev}</option>
                </c:forEach>
            </select> 
                <div><input type="submit" value="Hozzáad"></div>
            </fieldset>
     </form>
       
    </body>
</html>


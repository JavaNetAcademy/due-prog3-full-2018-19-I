<%-- 
    Document   : delarmors
    Created on : 2018.11.13., 21:50:49
    Author     : 
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
       
      <form action="/hoe/user/armor/delarmor" method="post">
            <select name="selectedArmor">
                <c:forEach var="ar" items="${armors}">
                    <option value="${ar.id}">${ar.nev}</option>
                </c:forEach>
            </select> 
            </br>
            <fieldset>
                <legend>Módosítás</legend>
                <div>
                    <label>New name: </label>
                    <input type="text" name="newname">
                </div>
                <div>
                    <label>New description: </label>
                    <input type="text" name="newinfo">
                </div>
                <div>
                    <label>Tamadoertek: </label>
                    <input type="number" min="0" name="newtamadoertek">
                </div>
                 <div>
                    <label>Vedoertek: </label>
                    <input type="number" min="0" name="newvedoertek">
                </div>
                 <select name="selectednyersanyag">
                <c:forEach var="ar" items="${resources}">
                    <option value="${ar.id}">${ar.nev}</option>
                </c:forEach>
            </select> 
                <div>
                    <input type="submit" name="modify" value="Modify" onclick="return confirm('Are you sure you want to modify this item?')">
                </div>
            </fieldset>
            <fieldset>
                <legend>Törlés</legend>
                    <input type="submit" name="delete" value="Delete" onclick="return confirm('Are you sure you want to delete this Item?')">
            </fieldset>
           </form>
    </body>
</html>

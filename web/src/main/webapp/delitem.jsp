<%-- 
    Document   : delitem
    Created on : 2018.11.08., 16:19:38
    Author     : Nagy Adam
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
       
      <form action="/hoe/user/items/delitem" method="post">
            <select name="selectedItem">
                <c:forEach var="it" items="${items}">
                    <option value="${it.id}">${it.nev}</option>
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
                    <label>Amount: </label>
                    <input type="number" min="0" name="newamount">
                </div>
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

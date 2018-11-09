<%-- 
    Document   : newVehicle
    Created on : 2018.11.08., 22:26:10
    Author     : ttama
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New vehicle</title>
    </head>
    <body>
     <form action="/hoe/newVehicle.jsp" method="post">
            <fieldset>
                <legend>New vehicle</legend>
                <div>
                    <label>Id: </label>
                    <input name="id">
                </div>
                <div>
                    <label>Name: </label>
                    <input name="name">
                </div>
                <div>
                    <label>Description: </label>
                    <input name="info">
                </div>
                <div>
                <label>Speed: </label>
                <input name="speed">
                </div>
                <div><input type="submit" value="Add new">
                </div>
            </fieldset>
        </form>
        <td><button onclick="/hoe/vehicle.jsp">Back</button></td>
    </body>
</html>
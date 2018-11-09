<%-- 
    Document   : vehicleModification
    Created on : 2018.11.08., 23:26:19
    Author     : ttama
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change vehicle</title>
    </head>
    <body>
     <form action="/hoe/vehicleModification" method="post">
            <fieldset>
                <legend>Vehicle modification</legend>
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
                <div><input type="submit" value="Change"></div>
            </fieldset>
        </form>
    </body>
</html>

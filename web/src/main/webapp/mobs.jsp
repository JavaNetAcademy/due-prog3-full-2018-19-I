<%-- 
    Document   : mobs
    Author     : Major Bence
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>Mob hozzáadása</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/hoe/user/mobs/new" method="post">
            <fieldset>
                <legend>Új mob </legend>
                <div>
                    <label>Mob neve: </label>
                    <input name="nev">
                </div>
                <div>
                    <label>Szintje: </label>
                    <input name="lvl">
                </div>
                <div>
                <label>Támadási pontja: </label>
                <input name="attackpoints">
                </div>
                <div>
                    <label>Védelmi pontja: </label>
                    <input name="defendpoints">
                </div>
                <div>
                    <label>X koordinátája: </label>
                    <input name="posx">
                </div>
                <div>
                    <label>Y koordinátája: </label>
                    <input name="posy">
                </div>
                <div><input type="submit" value="Hozzáadás"></div>
            </fieldset>
        </form>
        </body>
</html>

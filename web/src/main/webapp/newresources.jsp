<%-- 
    Document   : newresources
    Created on : Nov 9, 2018, 11:18:53 AM
    Author     : I-117-13.hallgato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Resources</title>
    </head>
    <body>
     <form action="/hoe/user/resources/new" method="post">
            <fieldset>
                <legend>New Resources</legend>
                <div>
                    <label>Resource name: </label>
                    <input name="nev">
                </div>
                <div>
                    <label>Description: </label>
                    <input name="info">
                </div>
                <div>
                <label>Quantity: </label>
                <input type="number" min="0" name="mennyiseg" >
                </div>
                <div><input type="submit" value="Hozzáad" onclick="Szamot()"></div>
            </fieldset>
     </form>
       
    </body>
</html>

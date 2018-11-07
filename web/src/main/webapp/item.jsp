<%-- 
    Document   : item
    Author     : Nagy Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>Create Item/title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/hoe/user/items/new" method="post">
            <fieldset>
                <legend>New Item</legend>
                <div>
                    <label>Item name</label>
                    <input name="nev">
                </div>
                <div>
                    <label>Description </label>
                    <input name="info">
                </div>
                <div>
                <label>Count</label>
                <input name="mennyiseg">
                </div>
                <div><input type="submit" value="Hozzáad"></div>
            </fieldset>
        </form>
        </body>
</html>

<%-- 
    Document   : heroclass
    Created on : 2018.11.08., 12:56:03
    Author     : Norbi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Hero Class</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/hoe/newheroclass" method="post">
            <fieldset>
                <legend>New Hero Class </legend>
                <div>
                    <label>Hero ID: </label>
                    <input name="heroid">
                </div>
                <div>
                    <label>Hero Class name: </label>
                    <input name="name">
                </div>
                <div>
                    <label>Description: </label>
                    <input name="description">
                </div>
                <div><input type="submit" value="Hozzáad"></div>
            </fieldset>
        </form>
    </body>
</html>

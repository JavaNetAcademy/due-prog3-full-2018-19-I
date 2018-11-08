<%-- 
    Document   : myodyfyitem
    Created on : 2018.11.08., 16:38:01
    Author     : Nagy Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <fieldset>
                <legend>Modify selected Item</legend>
                <div>
                    <label>New name: </label>
                    <input type="text" name="newname">
                </div>
                <div>
                    <label>New Item: </label>
                    <input type="text" name="newdesc">
                </div>
                <div>
                    <input type="submit" name="modify" value="Modify" onclick="return confirm('Are you sure you want to modify this location?')">
                </div>
            </fieldset>
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/hoe/user/locations/new" method="post">
            <fieldset>
                <legend>New location</legend>
                <div>
                    <label>Location name</label>
                    <input name="pname">
                </div>
                <div>
                    <label>Description </label>
                    <input name="pdesc">
                </div>
                <div><input type="submit" value="Add"></div>
            </fieldset>
        </form>
    </body>
</html>
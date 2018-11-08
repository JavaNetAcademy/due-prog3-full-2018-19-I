<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>Create Spell</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="/hoe/newspell" method="post">
            <fieldset>
                <legend>Új Spell </legend>
                <div>
                    <label>Hős ID: </label>
                    <input name="heroid">
                </div>
                <div>
                    <label>Spell név: </label>
                    <input name="name">
                </div>
                <div>
                    <label>Mennyiség: </label>
                    <input name="description">
                </div>
                <div>
                    <label>Támadó erő: </label>
                    <input name="attpower">
                </div>
                <div>
                    <label>Védekező erő: </label>
                    <input name="deffpower">
                </div>
                <div><input type="submit" value="Hozzáad"></div>
            </fieldset>
        </form>
        </body>
</html>

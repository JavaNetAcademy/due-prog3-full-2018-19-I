<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="location" method="post">
            <fieldset>
                <legend>Település létrehozása</legend>
                <div>
                    <label>Település neve</label>
                    <input name="pname">
                </div>
                <div>
                    <label>Leírása </label>
                    <input name="pdesc">
                </div>
                <div>
                    <label>Birodalom azonosítója </label>
                    <input name="pempid">
                </div>
                <div><input type="submit"></div>
            </fieldset>
        </form>
        <form action="query" method="post">
            <fieldset>
                <legend>Bejelentkezés</legend>
                <div>
                    <label>Felhasználó neve</label>
                    <input name="pname">
                </div>
                <div>
                    <label>Jelszó </label>
                    <input name="ppassword">
                </div>
                <div><input type="submit"></div>       
            </fieldset>
        </form>
    </body>
</html>
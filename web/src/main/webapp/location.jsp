<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="location" method="post">
            <fieldset>
                <legend>Telep�l�s l�trehoz�sa</legend>
                <div>
                    <label>Telep�l�s neve</label>
                    <input name="pname">
                </div>
                <div>
                    <label>Le�r�sa </label>
                    <input name="pdesc">
                </div>
                <div>
                    <label>Birodalom azonos�t�ja </label>
                    <input name="pempid">
                </div>
                <div><input type="submit"></div>
            </fieldset>
        </form>
        <form action="query" method="post">
            <fieldset>
                <legend>Bejelentkez�s</legend>
                <div>
                    <label>Felhaszn�l� neve</label>
                    <input name="pname">
                </div>
                <div>
                    <label>Jelsz� </label>
                    <input name="ppassword">
                </div>
                <div><input type="submit"></div>       
            </fieldset>
        </form>
    </body>
</html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Brugerregistrering</title>
    </head>
    <body>
        <h1>Opret dig som bruger</h1>
        <form action="frontControl" method="POST">
            
            Fornavn:<br>
            <input type="text" name="firstName" autofocus required><br>
            Efternavn<br>
            <input type="text" name="lastName" required><br>
            Telefonnummer:<br>
            <input type="text" name="phone"><br>
            Email:<br>
            <input type="text" name="email" required><br>
            Adgangskode:<br>
            <input type="password" name="password" required><br>
            Rolle:<br>
            <input type="radio" name="role" value="1" checked>Bruger
            <input type="radio" name="role" value="2">Behandler
            <input type="radio" name="role" value="3">Administrator<br>

            <input type="hidden" name="origin" value=register><br>
            <input type="submit" name="submit" value="Registrer">
        </form>
    </body>
</html>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Healthcare Booking</title>
    </head>
    <body>
        <h1>Book tid</h1>
        <form action="frontControl" method="post">
            <strong>Vælg behandling:</strong><br>
            <input type="radio" name="behandling" value="1">Fysioterapi<br>
            <input type="radio" name="behandling" value="2">Massage<br>
            <input type="radio" name="behandling" value="3">Kiropraktik<br>
            <input type="radio" name="behandling" value="4">Akupunktur<br>
            <br>
            <!--<strong>Vælg dato: </strong><input type="date" name="date"><br>
            <strong>Vælg tid: </strong><input type="time" name="time"><br>-->
            <strong>Vælg dato og tid:</strong><br>
            <input type="date" name="date" required><br>
            <input type="time" name="time" required><br>
            <input type="datetime-local" name="date-time" required><br>
            <input type="hidden" name="origin" value="booktid"><br>
            <input type="submit" name="submit" value="Book tid">
        </form>
    </body>
</html>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <p style="color:red">${message}</p>
        
        <form action="frontControl" method="POST">
            Email:<br>
            <input type="email" name="email"><br>
            Adgangskode:<br>
            <input type="password" name="pwd" required><br>
            
            <input type="hidden" name="origin" value="login">
            <input type="submit" name="submit" value="Login">
        </form>
    </body>
</html>

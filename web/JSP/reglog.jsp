<%-- 
    Document   : index
    Created on : 27-gen-2019, 4.31.33
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pasticceria Gemelli - Login</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto:100,400,700" rel="stylesheet">
        <link rel="icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <link rel="stylesheet" href="../CSS/reglog.css">     
        <!-- IMPORT DI JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    </head>
    <body>
        <p id="login-register__error" class="animatedBounceIn"></p>
        <div id ="login" class="login-register__form animatedBounceIn">
            <form action="../user?azione=login" method="POST">
                <input type="text" name="username" placeholder="Username" required="required">
                <input type="password" name="password" placeholder="Password" required="required"><br>
                <input type="submit">
                <p class="login-register__change">Non hai un account? <a class="register__link" href="">Registrati</a></p>
            </form>
        </div>

        <div id ="register" class="login-register__form invisible animatedBounceIn">
            <p id="login-register__error"></p>
            <form action="../user?azione=register" method="POST">
                <input type="text" name="nome" placeholder="Nome" required="required">
                <input type="text" name="cognome" placeholder="Cognome" required="required">
                <input type="text" name="username" placeholder="Username" required="required">
                <input type="password" name="password" placeholder="Password" required="required"><br>
                <input type="submit">
                <p class="login-register__change">Hai gia un account? <a class="login__link" href="">Login</a></p>
            </form>
        </div>




        <script>
            function getUrlVars() {
                var vars = {};
                var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
                    vars[key] = value;
                });
                return vars;
            }
            var failed = getUrlVars()["failed"];
            if (failed === "reg") {
                $("#register").toggleClass("invisible");
                $("#login").toggleClass("invisible");
                document.getElementById("login-register__error").innerHTML = "Username gia utilizzato";
            }
            if (failed === "log") {
                document.getElementById("login-register__error").innerHTML = "Username o password errati";
            }
            //I link ricaricano la pagina automaticamente
            $(".login__link").click(function (e) {
                //Evita di far ricaricare la pagina e perdere i toggle avvenuti in precedenza
                e.preventDefault();
                $("#register").toggleClass("invisible");
                $("#login").toggleClass("invisible");
            });
            $(".register__link").click(function (e) {
                //Evita di far ricaricare la pagina e perdere i toggle avvenuti in precedenza
                e.preventDefault();
                $("#login").toggleClass("invisible");
                $("#register").toggleClass("invisible");
            });
        </script>

    </body>
</html>

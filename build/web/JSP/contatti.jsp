<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../CSS/contatti.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" />
        <link rel="icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <title>Pasticceria Gemelli - Contatti</title>
    </head>
    <body>
        <div id="main">
        <div id="menutop"><%@ include file="menutop.jsp" %></div>

        <div class="contatti">
            <h2>Contatti</h2>
            <div class="infoContatti">
            <p>e-mail: pasticceriagemelli@sweet.it</br>
            telefono: 089 561 4780</div>
            </br>
            </br>
            <h2>Orari di apertura</h2>
            <div class="infoContatti">
            Lunedì 7:00 - 23:00</br>
            Martedì CHIUSO</br>
            Mercoledì 7:00 - 23:00</br>
            Giovedì 7:00 - 23:00</br>
            Sabato 7:00 - 23:00</br>
            Domenica 7:00 - 13:00</div>
        </div>
        
        <div class="vetrina">
            <img src="../IMAGE/vetrina.jpg">
        </div>
        </div>
        
        <div id="footer"><%@ include file="footer.jsp" %></div>
    </body>
</html>

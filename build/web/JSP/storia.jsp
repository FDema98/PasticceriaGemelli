<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height, target-densitydpi=device-dpi">
        <link rel="stylesheet" href="../CSS/storia.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" /><link rel="icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <title>Pasticceria Gemelli - Storia</title>
    </head>
    <body>
        <div id="menutop"><%@ include file="menutop.jsp" %></div>
        
         <script>
            function loadDoc() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("history").innerHTML =
                                this.responseText;
                    }
                }
                xhttp.open("GET", "../FILE/storia.txt");
                xhttp.send();
            }
            loadDoc();
        </script>  
        
        <div id="main">
            <img class="foto" src="../IMAGE/storiaFAM.jpg" alt="Avatar" class="image">
            <div id="history" class="testo"></div>
        </div>
         

        <div id="footer"><%@ include file="footer.jsp" %></div>
    </body> 
</html>

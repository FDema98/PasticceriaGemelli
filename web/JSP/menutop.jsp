
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menu</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto:100,400,700" rel="stylesheet">
        <link rel="stylesheet" href="../CSS/menutop.css">
    </head>
    <body>
        <div class="navbar" id="myTopNav">    
            <div class="navbarCont">
            <a class="item underline" href="home.jsp">HOME</a>
            <a class="item" href="storia.jsp">STORIA</a>
            <a class="item" href="shop.jsp">SHOP</a>
            <a class="item" href="ordini.jsp">ORDINI</a>
            <a class="item" href="doveSiamo.jsp">DOVE SIAMO</a>
            <a class="item" href="contatti.jsp">CONTATTI</a>
            <a class="item" id="logout" href="../user?azione=logout">LOGOUT</a>
            <a href="javascript:void(0);" class="icon underline" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
            </div>
        </div>

        <script>
            function myFunction() {
                var x = document.getElementById("myTopNav");
                if (x.className === "navbar") {
                    x.className += " responsive";
                } else {
                    x.className = "navbar";
                }
            }
        </script>
    </body>
</html>

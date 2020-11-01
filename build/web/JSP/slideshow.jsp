
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Slideshow</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto:100,400,700" rel="stylesheet">
        <link rel="stylesheet" href="../CSS/slideshow.css">
    </head>
    <body>

        <div class="slider-wrapper">
            <div class="slider">
                <input type="radio" name="slider" class="trigger" id="one" checked="checked" />
                <div class="slide">
                    <figure class="slide-figure">
                        <img class="slide-img" src="../IMAGE/slide1.jpg" />
                    </figure><!-- .slide-figure -->
                </div><!-- .slide -->
                <input type="radio" name="slider" class="trigger" id="two" />
                <div class="slide">
                    <figure class="slide-figure">
                        <img class="slide-img" src="../IMAGE/slide2.jpg" />
                    </figure><!-- .slide-figure -->
                </div><!-- .slide -->
                <input type="radio" name="slider" class="trigger" id="three" />
                <div class="slide">
                    <figure class="slide-figure">
                        <img class="slide-img" src="../IMAGE/slide3.jpg" />
                    </figure><!-- .slide-figure -->
                </div><!-- .slide -->
            </div><!-- .slider -->
            <ul class="slider-nav">
                <li class="slider-nav__item"><label class="slider-nav__label" for="one">1</label></li>
                <li class="slider-nav__item"><label class="slider-nav__label" for="two">2</label></li>
                <li class="slider-nav__item"><label class="slider-nav__label" for="three">3</label></li>
            </ul><!-- .slider-nav -->
        </div><!-- .slider-wrapper -->
    </body>
</html>

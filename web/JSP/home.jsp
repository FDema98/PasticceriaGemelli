<%@page import="gestionecarrello.Carrello"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="gestioneutente.Utente"%>
<%@page import="gestioneprodotti.Prodotto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gestioneutente.SessioneUtente"%>
<html>
    <head>
        <link rel="stylesheet" href="../CSS/home.css">
        <link rel="icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height, target-densitydpi=device-dpi">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" />
        <title>Pasticceria Gemelli - Home</title>
    </head>
    <body> 
        <div id="menutop"><%@ include file="menutop.jsp" %></div>     
        <div id="main">
            <div class="logoPasticceria"></div>
        <%
            if (request.getSession().getAttribute("usernameLog") == null) {
                response.sendRedirect("reglog.jsp");
                return;
            }
            SessioneUtente su = (SessioneUtente) request.getSession().getAttribute("Utente");
            if (su == null) {
                response.sendRedirect(request.getContextPath() + "/reglog.jsp");
            } else {
            ArrayList<Prodotto> lista = (ArrayList<Prodotto>) request.getSession().getAttribute("prisultato");
            if (lista == null) {
                System.out.println("Lista Prodotti non trovata");
                response.sendRedirect("/ProdottiServlet?azione=stampaProdotti&redirect=home");
                return;
            } else {
                request.getSession().removeAttribute("prisultato");
                if (!lista.isEmpty()) {
        %><div class="sweetContainer"><%
            for (int i= 0; i<lista.size(); i++) {
                if (lista.get(i).getId() > 6) continue;
                Prodotto x = lista.get(i);%>
            <a href="../ProdottiServlet?azione=visualizzaProdotto&id=<%=x.getId()%>">
                 <div class = "sweetbox image" style="background-image: url(<%
                     if (x.getId() == 1) %>../IMAGE/1macaron.jpg);"><%;
                        if (x.getId() == 2) %>../IMAGE/2biscotti.jpg);"><%;
                        if (x.getId() == 3) %>../IMAGE/3cioccolato.jpg);"><%;
                        if (x.getId() == 4) %>../IMAGE/4mignon.jpg);"><%;
                        if (x.getId() == 5) %>../IMAGE/5muffin.jpg);"><%;
                        if (x.getId() == 6) %>../IMAGE/6torta.jpg);"><%;%>
                    <div class="overlay">
                        <div class="sweetEtichetta"><%=x.getNome()%></div>
                    </div>
                </div></a>                       
                <%}%>
        </div><%} else {%>              
        <p class="errorRicerca">Nessun prodotto in database</p>
        <%}
                }
            }%>        
        </div>
        <div id="footer"><%@ include file="footer.jsp" %></div>
    </body>
</html>

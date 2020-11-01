<%@page import="gestioneprodotti.Prodotto"%>
<%@page import="gestioneutente.SessioneUtente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <link rel="stylesheet" href="../CSS/visualizzaProdotto.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" />
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <!-- IMPORT DI JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <title>Pasticceria Gemelli - Prodotto</title>
    </head>
    <body>
        <div id="menutop"><%@ include file="menutop.jsp" %></div>
        <div id="main">
            <%
                SessioneUtente su = (SessioneUtente) request.getSession().getAttribute("Utente");

                if (su == null) {
                    response.sendRedirect(request.getContextPath() + "/Login.jsp");
                } else {
                    Prodotto x = (Prodotto) request.getSession().getAttribute("prodottoTrovato");
                    System.out.println("Siamo in visualizza prodotto");
                    if (x == null) {
                        System.out.println("X non esiste");
                        response.sendRedirect("/JSP/home.jsp");
                    } else {
            %>     
            <div class="prodotto">
                 <img class="immagineProdotto" src="<%
                     if (x.getId() == 1) %>../IMAGE/1macaron.jpg"><%;
                          if (x.getId() == 2) %>../IMAGE/2biscotti.jpg"><%;
                             if (x.getId() == 3) %>../IMAGE/3cioccolato.jpg"><%;
                                     if (x.getId() == 4) %>../IMAGE/4mignon.jpg"><%;
                                if (x.getId() == 5) %>../IMAGE/5muffin.jpg"><%;
                                if (x.getId() == 6) %>../IMAGE/6torta.jpg"><%;
                                if (x.getId() > 6) %>../IMAGE/dolce.jpg"><%;%>                       
                <div class="prodottoNome"><%=x.getNome()%></div>
                <div class="prodottoPrezzo"><%=String.format("%.2f", x.getPrezzo())%>€</div>            
                <div class="descrizioneProdotto"><%=x.getDescrizione()%></div>
                <%if (!su.isAdmin()) {%>
                <div class="aggiungiCarrello">
                    <form class="formCart" action="../CarrelloServlet" style="display: inline-block">                     
                        <input class="quantita" type="number" name="quantita" min="1" max="10" value="1">
                        <input type="hidden" name = "azione" value="addCart">
                        <input type="hidden" name = "id" value="<%=x.getId()%>">
                        <button class="addCartButton" type="submit">Aggiungi al carrello</button>
                    </form>
                </div>
                <%}%>
                <%if (su.isAdmin()) {%>
                <div class="deleteProdotto">
                    <form class="formCart" action="../ProdottiServlet?azione=rimuoviProdotto" method="POST">
                        <input type="hidden" name = "id" value="<%=x.getId()%>">
                        <input class="deleteButton" type="submit" value="Elimina">
                    </form>
                </div>
                <%}%>
            </div>
            <% if (su.isAdmin()) {%>
            <div class="admin">                
                <div class="prodottoNome">Modifica Prodotto</div>
                <form action="../ProdottiServlet?azione=modificaProdotto" method="POST">
                    <input type="hidden" name = "id" value="<%=x.getId()%>">
                    <input type="text" name="nome" placeholder="Nome" required="required" value="<%=x.getNome()%>">
                    <input type="text" name="prezzo" placeholder="Prezzo" required="required" value="<%=x.getPrezzo()%>">
                    <textarea rows="10" class="descrizioneField" name="descrizione" placeholder="Descrizione" required="required"><%=x.getDescrizione()%></textarea>
                    <input type="submit" value="Conferma">
                </form>

            </div>
            <%}
                    }
                }%>
        </div>      
        <div id="footer"><%@ include file="footer.jsp" %></div>
    </body>
</html>

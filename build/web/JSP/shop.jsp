<%@page import="gestionecarrello.Carrello"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="gestioneutente.Utente"%>
<%@page import="gestioneprodotti.Prodotto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gestioneutente.SessioneUtente"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="../IMAGE/sweet.ico" type="image/x-icon" />
        <link rel="stylesheet" href="../CSS/shop.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" />
        <title>Pasticceria Gemelli - Shop</title>
    </head>
    <body>
        <div id="menutop"><%@ include file="menutop.jsp" %></div>
        <div id="main">
            <div id="shop">
                <% if (request.getSession().getAttribute("usernameLog") == null) {
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
                            response.sendRedirect("/ProdottiServlet?azione=stampaProdotti&redirect=shop");
                            return;
                        } else {
                            request.getSession().removeAttribute("prisultato");
                            if (!lista.isEmpty()) {

                                for (Prodotto x : lista) {%>

                <div class="article">
                    <a href="../ProdottiServlet?azione=visualizzaProdotto&id=<%=x.getId()%>">
                        <div class="articleImage">
                               <image class="image" src="<%
                                   if (x.getId() == 1) %>../IMAGE/1macaron.jpg"><%;
                                          if (x.getId() == 2) %>../IMAGE/2biscotti.jpg"><%;
                                           if (x.getId() == 3) %>../IMAGE/3cioccolato.jpg"><%;
                                                  if (x.getId() == 4) %>../IMAGE/4mignon.jpg"><%;
                                                   if (x.getId() == 5) %>../IMAGE/5muffin.jpg"><%;
                                                      if (x.getId() == 6) %>../IMAGE/6torta.jpg"><%;
                                                       if (x.getId() > 6) %>../IMAGE/dolce.jpg"><%;%>
                        </div>
                        <div class="articleInfo">
                            <div class="articleNome"><%=x.getNome()%></div>
                    </a>
                    <div class="articlePrezzo">€<%=String.format("%.2f", x.getPrezzo())%></div>                                                              
                    <div class="aggiungiCarrello">
                        <form class="formCart" action="../CarrelloServlet" style="display: inline-block">                     
                            <!--<input class="quantita" type="number" name="quantita" min="1" max="10" value="1">
                            -->
                            
                            <select name="quantita" class="quantitabox">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>

                            <input type="hidden" name = "azione" value="addCart">
                            <input type="hidden" name = "id" value="<%=x.getId()%>">
                            <button class="addCartButton" type="submit">Aggiungi al carrello</button>
                        </form>
                    </div>
                </div>
            </div>
            <%}%>
            <%} else {%>              
            <p class="errorRicerca">Nessun prodotto in database</p>
            <%}
                }
            %> 
            <%if (su.isAdmin()) {%>
            <div class="article">
                <div class="articleImage" onclick="openForm()">
                    <image class="image" src="../IMAGE/nuovo.jpg">
                </div>
                <div class="articleInfo">
                    <button id="nuovo" class="acquistaButton" onclick="openForm()">Nuovo Prodotto</button>
                </div>

                <script>
                    function openForm() {
                        document.getElementById("myForm").style.display = "block";
                    }

                    function closeForm() {
                        document.getElementById("myForm").style.display = "none";
                    }
                </script>
            </div>
            <%;
                        }
                    }%>
        </div>
        <div class="form-popup" id="myForm">
            <form action="../ProdottiServlet?azione=creaProdotto" method="POST">
                <input type="text" name="nome" placeholder="Nome" required="required">
                <input type="text" name="prezzo" placeholder="Prezzo" required="required">
                <textarea rows="10" class="descrizioneField" name="descrizione" placeholder="Descrizione" required="required"></textarea>
                <input type="submit" value="Conferma">
                <button type="button" class="btn cancel" onclick="closeForm()">Annulla</button>
            </form>
        </div>
        <div id="cart">
            <div class="cartWindow">
                <div class="cartCarrello">CARRELLO</div>
                <%
                    Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
                    ArrayList<Prodotto> listaCart = (ArrayList<Prodotto>) cart.getLista();
                    float prezzoTot = 0;
                    for (Prodotto x : listaCart) {
                        prezzoTot += x.getPrezzo() * x.getQuantita();%>
                <div class="cartProduct"><%=x.getQuantita()%> x <%=x.getNome()%> - €<%=String.format("%.2f", x.getPrezzo())%>
                    <div class="modificaCarrello">
                        <form class="setButton" action="../CarrelloServlet">
                            <input class="quantita" type="number" name="quantita" min="1" max="10" value="1">
                            <input type="hidden" name = "azione" value="setCart">
                            <input type="hidden" name = "id" value="<%=x.getId()%>">
                            <button type="submit">Applica</button>
                        </form> 
                        <form class="removeButton" action="../CarrelloServlet">
                            <input type="hidden" name = "azione" value="delCart">
                            <input type="hidden" name = "id" value="<%=x.getId()%>">
                            <button type="submit">Rimuovi</button>
                        </form>
                    </div>
                </div>
                <%}%>
                <div class="cartTotal">
                    <div class="testoTot">
                        TOTALE: €<%=String.format("%.2f", prezzoTot)%>
                    </div>
                    <form class="removeButton" action=<%if (!listaCart.isEmpty()) { %>"../OrdiniServlet" <%}%>>
                        <input type="hidden" name = "azione" value="creaOrdine">
                        <button class="acquistaButton" type="submit">Acquista</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div id="footer"><%@ include file="footer.jsp" %></div>
</body>
</html>

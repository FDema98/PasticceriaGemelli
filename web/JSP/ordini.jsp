<%@page import="gestioneprodotti.Prodotto"%>
<%@page import="gestioneutente.SessioneUtente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gestioneordini.Ordine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../CSS/ordini.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" />
        <title>Ordini</title>
    </head>
    <body>
        <div id="menutop"><%@ include file="menutop.jsp" %></div>
        <div id="main">
                <% if (request.getSession().getAttribute("usernameLog") == null) {
                        response.sendRedirect("reglog.jsp");
                        return;
                    }
                    SessioneUtente su = (SessioneUtente) request.getSession().getAttribute("Utente");
                    if (su == null) {
                        response.sendRedirect(request.getContextPath() + "/reglog.jsp");
                    } else {
                        ArrayList<Ordine> lista = (ArrayList<Ordine>) request.getSession().getAttribute("orisultato");
                        if (lista == null) {
                            System.out.println("Lista Ordini non trovata");
                            response.sendRedirect("/OrdiniServlet?azione=stampaOrdini");
                            return;
                        } else {
                            request.getSession().removeAttribute("orisultato");
                            if (!lista.isEmpty()) {
                                for (Ordine x : lista) {
                                    if (su.isAdmin()) {%>
                <div class="ordine" style="width: 1000px">           
                    <div class="ordineUtente">Ordine di <%=x.getUsername()%></div>
                    <%for (Prodotto y : x.getLista()) { %>
                    <div class="ordineInfo"><%=y.getQuantita()%>x <%=y.getNome()%></div>
                </div>
            <%
                        }
                                    } else; //non sei admin
                                }%>
            <%} else {%>              
            <p class="errorRicerca">Nessun ordine in database</p>
                    <%}
                    }
                    }
            %> 
    </div>
    <div id="footer"><%@ include file="footer.jsp" %></div>
    </body>
</html>

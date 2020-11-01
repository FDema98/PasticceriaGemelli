/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioneordini;

import gestionecarrello.Carrello;
import gestioneprodotti.Prodotto;
import gestioneprodotti.ProdottoManager;
import gestioneutente.SessioneUtente;
import gestioneutente.UtenteManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrdiniServlet")
public class OrdiniServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    OrdineManager ordineManager = new OrdineManager();
    ProdottoManager prodottoManager = new ProdottoManager();
    UtenteManager utenteManager = new UtenteManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        SessioneUtente sessione = (SessioneUtente) request.getSession().getAttribute("Utente");
        String usernameLog = sessione.getUsername();
        try {
            String azione = request.getParameter("azione");
            System.out.println("OrdiniServlet azione = " +azione);

            if (azione.equalsIgnoreCase("stampaOrdini")) {
                ArrayList<Ordine> risultato = recuperaOrdini();
                request.getSession().setAttribute("orisultato", risultato);
                response.sendRedirect(request.getContextPath() + "/JSP/ordini.jsp");                
            }

            if (azione.equalsIgnoreCase("creaOrdine")) {
                String utente = request.getParameter("usernameUtente");
                Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
                ArrayList<Prodotto> listaCart = (ArrayList<Prodotto>) cart.getLista();
                creaOrdine(usernameLog, listaCart);
                cart.getLista().clear();
                request.setAttribute("carrello", cart);
                response.sendRedirect("/JSP/ordini.jsp");
                
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Ordine> recuperaOrdini() throws SQLException {
        return ordineManager.recuperaOrdini();
    }

    private void creaOrdine(String username, ArrayList<Prodotto> lista) throws SQLException{
        Ordine temp = new Ordine(username, lista);
        System.out.println("inizio creazione ordine");
        ordineManager.creaOrdine(temp);
    }

}

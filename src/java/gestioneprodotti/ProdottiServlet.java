package gestioneprodotti;

import gestioneutente.SessioneUtente;
import gestioneutente.Utente;
import gestioneutente.UtenteManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * La Servlet della classe Annuncio si occupa delle logiche applicative degli
 * annunci.
 */
@WebServlet("/ProdottiServlet")
public class ProdottiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
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
            System.out.println("ProdottiServlet azione = " +azione);

            if (azione.equalsIgnoreCase("stampaProdotti")) {
                ArrayList<Prodotto> risultato = recuperaProdotti();
                request.getSession().setAttribute("prisultato", risultato);
                if (request.getParameter("redirect").equals("home"))
                response.sendRedirect(request.getContextPath() + "/JSP/home.jsp");
                if (request.getParameter("redirect").equals("shop"))
                response.sendRedirect(request.getContextPath() + "/JSP/shop.jsp");
                
            }

            if (azione.equalsIgnoreCase("rimuoviProdotto")) {
                //SE E' LOGGATO UN ADIMN
                int id = Integer.parseInt(request.getParameter("id"));
                rimuoviProdotto(id);
                response.sendRedirect(request.getContextPath() + "/JSP/shop.jsp");
            }

            if (azione.equalsIgnoreCase("modificaProdotto")) {
                //SE E' LOGGATO UN ADIMN
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                float prezzo = Float.parseFloat(request.getParameter("prezzo"));
                String descrizione = request.getParameter("descrizione");
                modificaProdotto(id, nome, prezzo, descrizione);
                
                response.sendRedirect(request.getContextPath() + "/JSP/visualizzaProdotto.jsp?id="+id);
            }

            if (azione.equalsIgnoreCase("creaProdotto")) {
                //SE E' LOGGATO UN ADIMN
                String utente = request.getParameter("usernameUtente");
                String nome = request.getParameter("nome");
                float prezzo = Float.parseFloat(request.getParameter("prezzo"));
                String descrizione = request.getParameter("descrizione");
                creaProdotto(nome, prezzo, descrizione);
                response.sendRedirect("/JSP/shop.jsp");
            }


            if (azione.equalsIgnoreCase("visualizzaProdotto")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Prodotto prodottoTrovato = prodottoManager.recuperaPerId(id);
                request.getSession().setAttribute("prodottoTrovato", prodottoTrovato);
                response.sendRedirect(request.getContextPath() + "/JSP/visualizzaProdotto.jsp?id=" + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Prodotto> recuperaProdotti() throws SQLException {
        return prodottoManager.recuperaProdotti();
    }

    private void rimuoviProdotto(int id) throws SQLException {
        Prodotto temp = prodottoManager.recuperaPerId(id);
        if (temp == null) {
            System.out.println("Prodotto da rimuovere non trovato");
        } else {
            prodottoManager.rimuoviProdotto(temp);
        }
    }

    private void modificaProdotto(int id, String nome, float prezzo, String descrizione) throws SQLException{
        Prodotto temp = prodottoManager.recuperaPerId(id);
        temp.setNome(nome);
        temp.setPrezzo(prezzo);
        temp.setDescrizione(descrizione);
        prodottoManager.modificaProdotto(temp);
    }

    private void creaProdotto(String nome, Float prezzo, String descrizione) throws SQLException{
        Prodotto temp = new Prodotto(nome, prezzo, descrizione);
        System.out.println("inizio creazione prodotto");
        prodottoManager.creaProdotto(temp);
    }

}

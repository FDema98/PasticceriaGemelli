/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecarrello;

import gestioneprodotti.Prodotto;
import gestioneprodotti.ProdottoManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 39334
 */
@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {

    Carrello<Prodotto> carrello;
    ProdottoManager prodottoManager = new ProdottoManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\n Gestione Carrello \n");
        //Recupero il carrello se esiste, altrimenti lo creo
        carrello = (Carrello<Prodotto>) request.getSession().getAttribute("carrello");
        if (carrello == null) {
            carrello = new Carrello<Prodotto>();
            request.getSession().setAttribute("carrello", carrello);
        }

        String action = request.getParameter("azione");

        try {
            if (action != null) {
                if (action.equalsIgnoreCase("addCart")) {
                    //Aggiungiamo al carrello
                    int id = Integer.parseInt(request.getParameter("id"));
                    int quantita = Integer.parseInt(request.getParameter("quantita"));
                    Prodotto temp = prodottoManager.recuperaPerId(id);
                    temp.setQuantita(quantita);
                    boolean inCart = false;
                    for (Prodotto x : carrello.getLista()) {
                        if (x.getId() == id) {
                            inCart = true;
                        }
                    }
                    if (!inCart) {
                        carrello.addProdotto(temp);
                    } else {              
                        for (Prodotto x : carrello.getLista()) {
                        if (x.getId() == id) {
                            x.setQuantita(quantita+x.getQuantita());
                        }
                    }
                    }
                } else if (action.equalsIgnoreCase("delCart")) {
                    //Cancella dal carrello
                    int id = Integer.parseInt(request.getParameter("id"));                
                    for (Prodotto x : carrello.getLista()) {
                        if (x.getId() == id) {
                            carrello.delete(x);
                            break;
                        }
                    }
                    if (carrello.getLista().isEmpty()) {
                        System.out.println("Il carrello è vuoto dopo la cancellazione");
                    }
                    System.out.println("Fine cancellazione prodotto servlet");
                } else if (action.equalsIgnoreCase("setCart")) {
                    //Modifichiamo quantita al prodotto
                    int id = Integer.parseInt(request.getParameter("id"));
                    int quantita = Integer.parseInt(request.getParameter("quantita"));
                    for (Prodotto x : carrello.getLista()) {
                        if (x.getId() == id) {
                            x.setQuantita(quantita);
                            break;
                        }
                    }
                    System.out.println("Fine aggiornamento quantità prodotto servlet");
                }

                response.sendRedirect("./JSP/shop.jsp");
                /*else if(action.equalsIgnoreCase("checkout")) {
                 doCheckout(request,response);*/

            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        /*
         if(action.equalsIgnoreCase("checkout") && ((SessioneUtente) request.getSession().getAttribute("Utente"))!=null && ((SessioneUtente) request.getSession().getAttribute("Utente")).getRuolo().equalsIgnoreCase("Utente") )
         response.sendRedirect(request.getContextPath() + "\\HTML\\Utente.jsp");
         */

        System.out.println("\n Fine gestione Carrello \n");
    }
}

package gestioneutente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import gestionecarrello.Carrello;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marco
 */
@WebServlet("/user")
public class UtenteServlet extends HttpServlet {

    UtenteManager manager = new UtenteManager();
    HttpSession session;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // LOGOUT
        session = request.getSession();
        System.out.println("-Inizio interazione POST-");
        try {
            String action = request.getParameter("azione");
            if (action.equals("logout")) {
                System.out.println("-Inizio logout-");
                //INVALIDO LA SESSIONE
                response.sendRedirect("./JSP/reglog.jsp");
                session.invalidate();
            }
        } catch (IOException exc) {
        } finally {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        //CREO SESSIONE
        session = request.getSession();
        Carrello carrello = new Carrello();
        System.out.println("-Inizio interazione POST-");
        try {
            String action = request.getParameter("azione");
            //LOGIN
            if (action.equals("login")) {
                System.out.println("-Inizio login-");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println("-Parametri recepiti-");
                Utente temp;
                temp = manager.doLogin(username, password);

                if (temp != null) {
                    SessioneUtente su;
                    System.out.println("-Utente registrato, sessione :" + request.getSession().getId() + " creata-");
                    su = new SessioneUtente(temp);
                    session.setAttribute("Utente", su);
                    session.setAttribute("usernameLog", temp.getUsername());
                    session.setAttribute("carrello", carrello);
                    System.out.println("\n FINE GESTIONE LOGIN\n");
                    response.sendRedirect("./JSP/home.jsp");
                } else {
                    System.out.println("-Utente non registrato-");
                    response.sendRedirect("./JSP/reglog.jsp?failed=log");
                }
            }
            //REGISTRAZIONE
            if (action.equals("register")) {
                System.out.println("-Inizio register-");
                String nome = request.getParameter("nome");
                String cognome = request.getParameter("cognome");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println("-Parametri recepiti-");
                if (manager.isAlreadyRegistered(username)) {
                    System.out.println("-Utente gia registrato-");
                    response.sendRedirect("./JSP/reglog.jsp?failed=reg");
                } else {
                    SessioneUtente su;
                    System.out.println("-Utente non registrato, procedura di register-");
                    manager.doRegister(username, nome, cognome, password);
                    Utente temp = new Utente(username, nome, cognome, password);
                    su = new SessioneUtente(temp);
                    session.setAttribute("Utente", su);
                    session.setAttribute("usernameLog", username);
                    session.setAttribute("carrello", carrello);
                    System.out.println("\n FINE GESTIONE REGISTRAZIONE \n");
                    response.sendRedirect("./JSP/home.jsp");
                }
            }
        } catch (SQLException | IOException exc) {
        } finally {
        }
    }
}

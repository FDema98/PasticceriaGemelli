package gestioneutente;

import java.io.Serializable;

public class SessioneUtente implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Crea una sessione utente.
     *
     * @param u utente
     */
    public SessioneUtente(Utente u) {
        username = u.getUsername();
        nome = u.getNome();
        cognome = u.getCognome();
        admin = u.isAdmin();
    }

    public SessioneUtente() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    

    private String username;
    private String nome;
    private String cognome;
    private boolean admin;
}

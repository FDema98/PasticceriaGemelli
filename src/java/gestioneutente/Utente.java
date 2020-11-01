package gestioneutente;

public class Utente {

    public Utente(String username, String nome, String cognome, String password) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        admin = false;
    }

    public Utente() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    private String password;
    private boolean admin;
}

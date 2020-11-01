package gestioneprodotti;

public class Prodotto {

    public Prodotto(int id, String nome, float prezzo, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
    }
    
    public Prodotto(String nome, float prezzo, String descrizione) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
    }

    public Prodotto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    private String nome;
    private int id;
    private float prezzo;
    private String descrizione;
    private int quantita;
}

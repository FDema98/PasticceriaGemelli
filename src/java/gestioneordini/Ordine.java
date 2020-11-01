/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioneordini;

import gestioneprodotti.Prodotto;
import java.util.ArrayList;

public class Ordine {
    
    public Ordine() {
        
    }
    
    public Ordine(String username, ArrayList<Prodotto> lista) {
        this.username = username;
        this.lista = lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Prodotto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Prodotto> lista) {
        this.lista = lista;
    }

 
    private int id;
    private String username;
    private ArrayList<Prodotto> lista;
}

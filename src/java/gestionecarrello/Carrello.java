/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionecarrello;

import java.io.Serializable;
import java.util.ArrayList;



public class Carrello<Prodotto> implements Serializable {

    public Carrello(ArrayList<Prodotto> lista) {
        this.lista= lista;    
    }
    
    public Carrello(){
        this.lista= new ArrayList<Prodotto>();
    }
    
   public void addProdotto(Prodotto prodotto){
       lista.add(prodotto);
       System.out.println("Aggiunto nuovo prodotto al carrello");
   }
   
    public void delete(Prodotto prodotto){
        if(lista.isEmpty())
            System.out.println("Il carrello è vuoto");
        else{
            lista.remove(prodotto);
            System.out.println("Prodotto eliminato");
        }

    }
    
    public ArrayList<Prodotto> getLista(){
        return lista;
    }
    
    ArrayList<Prodotto> lista;
    
}

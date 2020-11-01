package gestioneordini;

import gestioneprodotti.Prodotto;
import gestioneprodotti.ProdottoManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.DriverManagerConnectionPool;

public class OrdineManager {

    private static final String TABLENAME1 = "ordini";
    private static final String TABLENAME2 = "ordine_prodotti";
    private ProdottoManager prodottoManager = new ProdottoManager();

    public OrdineManager() {
    }
    
    public ArrayList<Ordine> recuperaOrdini() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Ordine> tempA = new ArrayList<Ordine>();
        Ordine tempB = new Ordine();
        String sql = "SELECT * FROM " + TABLENAME1;
        
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
            tempB.setId(rs.getInt(1));
            tempB.setUsername(rs.getString(2));
            tempB.setLista(recuperaInfo(tempB));          
            tempA.add(tempB);
            tempB = new Ordine();
            }
        } finally {
            DriverManagerConnectionPool.releaseConnection(connection);
        }
        return tempA;
    }

    
    public ArrayList<Prodotto> recuperaInfo(Ordine o) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Prodotto> tempA = new ArrayList<Prodotto>();
        Prodotto tempB = new Prodotto();      
        String str = Integer.toString(o.getId());
        String sql = "SELECT * FROM " + TABLENAME2 + " WHERE ordineID = ?  ";       
        String flush = "FLUSH TABLES " + TABLENAME2;
        try{
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(flush);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, str);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
            tempB.setId(rs.getInt("prodottoID"));
            tempB.setQuantita(rs.getInt("quantita"));
            tempB.setNome(prodottoManager.recuperaPerId(tempB.getId()).getNome());
            tempB.setPrezzo(prodottoManager.recuperaPerId(tempB.getId()).getPrezzo());
            tempA.add(tempB);   
            tempB= new Prodotto();
            }
        } finally {
            DriverManagerConnectionPool.releaseConnection(connection);
        }
        for (Prodotto y : tempA){
                System.out.println("Id="+y.getId()+" Quantita="+ y.getQuantita());
            }
        return tempA;
    }
    
    
    public int recuperaMaxId() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT MAX(id) FROM " + TABLENAME1;               
        String flush = "FLUSH TABLES " + TABLENAME2;
        int temp=0;
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(flush);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.first()) {
            temp = rs.getInt("MAX(id)");
            }
        } finally {
            DriverManagerConnectionPool.releaseConnection(connection);
        }
        System.out.println("QUESTO E' L'ID !!!!" + temp);
        return temp;
        
    }
    
    
    public void creaOrdine(Ordine ordine) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO " + TABLENAME1 + " VALUES(null, ?)";
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ordine.getUsername());;
            preparedStatement.executeUpdate();
            connection.commit();
        }     
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }
        sql = "INSERT INTO " + TABLENAME2 + " VALUES(null, ?,?,?)";
        for (int i=0; i<ordine.getLista().size();i++){
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, this.recuperaMaxId());
            preparedStatement.setInt(2, ordine.getLista().get(i).getId());
            preparedStatement.setInt(3,ordine.getLista().get(i).getQuantita());
            preparedStatement.executeUpdate();
            connection.commit();
        } 
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }
        }
    }

}

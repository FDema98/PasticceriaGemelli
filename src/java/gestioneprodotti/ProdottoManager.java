package gestioneprodotti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.DriverManagerConnectionPool;

public class ProdottoManager {

    private static final String TABLENAME = "Prodotti";

    public ProdottoManager() {
    }

    public ArrayList<Prodotto> listaProdotti(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        ArrayList<Prodotto> lista = new ArrayList<Prodotto>();
        Prodotto temp;
        int a = 0;
        int b = 0;
        while (rs.next()) {
            b++;
        }
        rs.first();
        while (!rs.isAfterLast()) {
            a++;
            temp = new Prodotto();
            temp.setId(rs.getInt(1));
            temp.setNome(rs.getString(2));
            temp.setPrezzo(rs.getFloat(3));
            temp.setDescrizione(rs.getString(4));
            lista.add(temp);
            rs.next();
        }
        return lista;
    }

    public void creaProdotto(Prodotto prodotto) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO " + TABLENAME + " VALUES(null, ?,?,?)";
        String flush = "FLUSH TABLES " + TABLENAME;
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(flush);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, prodotto.getNome());
            preparedStatement.setFloat(2, prodotto.getPrezzo());
            preparedStatement.setString(3, prodotto.getDescrizione());
            preparedStatement.executeUpdate();
            connection.commit();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }
    }

    public void rimuoviProdotto(Prodotto prodotto) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String delete = "DELETE FROM " + TABLENAME + " WHERE id = ?";
        String flush = "FLUSH TABLES " + TABLENAME;
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(flush);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, prodotto.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }
    }

    public void modificaProdotto(Prodotto prodotto) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE " + TABLENAME + " SET nome = ?, prezzo = ?, descrizione = ?" + " WHERE id = ?";
        String flush = "FLUSH TABLES " + TABLENAME;
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(flush);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, prodotto.getNome());
            preparedStatement.setFloat(2, prodotto.getPrezzo());
            preparedStatement.setString(3, prodotto.getDescrizione());
            preparedStatement.setInt(4, prodotto.getId());
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement = connection.prepareStatement(flush);
            preparedStatement.executeUpdate();
            connection.commit();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }
    }

    public ArrayList<Prodotto> recuperaProdotti() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Prodotto> temp = null;
        String sql = "SELECT * FROM " + TABLENAME;
        String flush = "FLUSH TABLES " + TABLENAME;
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(flush);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("Query: " + preparedStatement.toString());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.first()) {
                temp = listaProdotti(rs);
            }
        } finally {
            DriverManagerConnectionPool.releaseConnection(connection);
        }
        return temp;
    }

    public Prodotto recuperaPerId(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Prodotto temp = new Prodotto();
        String str = Integer.toString(id);
        String sql = "SELECT * FROM " + TABLENAME + " WHERE id = ?  ";
        String flush = "FLUSH TABLES " + TABLENAME;
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(flush);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, str);
            System.out.println("Query: " + preparedStatement.toString());
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                temp = null;
            } else {
                temp.setId(rs.getInt("id"));
                temp.setNome(rs.getString("nome"));
                temp.setPrezzo(rs.getFloat("prezzo"));
                temp.setDescrizione(rs.getString("descrizione"));
            }
        } finally {
            DriverManagerConnectionPool.releaseConnection(connection);
        }
        return temp;
    }
}

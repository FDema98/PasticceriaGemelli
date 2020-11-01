/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneutente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.DriverManagerConnectionPool;
import static org.apache.tomcat.jni.File.flush;

/**
 *
 * @author Marco
 */
public class UtenteManager {

    private static final String TableName = "utenti";
    private String TABLENAME;

    public UtenteManager() {
    }

    //UTENTE GIA REGISTRATO NEL DATABASE
    public boolean isAlreadyRegistered(String username) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + TableName + " WHERE Username=?";
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            System.out.println("isRegistered: " + preparedStatement.toString());
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
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

    //CONFRONTO USERNAME E PASSWORD INSERITI CON DATABASE
    public Utente doLogin(String username, String password) throws SQLException {
        Connection connection = null;
        Utente temp = new Utente();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + TableName + " WHERE username=? AND password=? ";
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println("doLogin: " + preparedStatement.toString());
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                temp.setUsername(rs.getString("Username"));
                temp.setNome(rs.getString("Nome"));
                temp.setCognome(rs.getString("Cognome"));
                temp.setPassword(rs.getString("Password"));
                temp.setAdmin(rs.getBoolean("admin"));
            } else {
                System.out.println("Non esiste");
                temp = null;
            }
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } finally {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }
        return temp;
    }

    //REGISTRA NUOVO UTENTE NEL DATABASE
    public void doRegister(String nome, String cognome, String username, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO " + TableName + " VALUES(?,?,?,?,0)";
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setString(4, cognome);

            System.out.println("doRegister: " + preparedStatement.toString());
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

}

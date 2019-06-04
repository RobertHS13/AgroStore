package com.example.agrostore01.CapaDatos.conexiones;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {

    private Connection connection;

    private String host;
    private String dbName;
    private String user;
    private String password;

    public BaseDeDatos() {
        host = "sql7005.site4now.net";
        dbName = "DB_A497D0_agrostore";
        user = "DB_A497D0_agrostore_admin";
        password = "fierro1000";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public BaseDeDatos(String host, String dbName, String user, String password) {
        this.host = host;
        this.dbName = dbName;
        this.user = user;
        this.password = password;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public Connection getConexion() {

        if (connection != null)
            return connection;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();

            String url = "jdbc:jtds:sqlserver://" + host + ";database=" + dbName + ";user=" + user + ";password=" + password;

            return DriverManager.getConnection(url);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

}

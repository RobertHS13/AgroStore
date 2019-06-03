package com.example.agrostore01.CapaDatos.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class BaseDeDatos {

        private Connection connection;

        private String host;
        private String dbName;
        private String user;
        private String password;

        public BaseDeDatos(String host, String dbName, String user, String password) {
            this.host = "localhost";
            this.dbName = "Mercado";
            this.user = "miguelgm";
            this.password = "PAPASOTE21";
        }

        public Connection getConexion() {
            if (connection != null)

                return connection;

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                String url = String.format("jdbc:sqlserver://%s;databaseName=%s", host, dbName);

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("conexion establecida");
                return connection;
            }
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


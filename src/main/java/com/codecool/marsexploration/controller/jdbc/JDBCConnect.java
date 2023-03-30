package com.codecool.marsexploration.controller.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnect {
    String URL;

    Connection connection;

    public JDBCConnect(String URL) {
        this.URL = URL;
        this.connection = null;
    }

    public Connection connect() {
        try {
            Class.forName( "org.postgresql.Driver" );
            String username = "myuser";
            String password = "linux23";
            connection = DriverManager.getConnection( URL, username, password );

            if (connection != null) {
                System.out.println( "Connection OK" );
                return connection;
            } else {
                System.out.println( "Connection failed" );
            }
        } catch (Exception e) {
            System.out.println( e );
        }
        return null;
    }
}

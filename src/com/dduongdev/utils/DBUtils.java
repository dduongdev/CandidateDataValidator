package com.dduongdev.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static DBUtils instance = null;
    private Connection connection;

    public DBUtils() {
        Properties properties = new Properties();

        try {
            properties.load(DBUtils.class.getResourceAsStream("/dbConfig.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            Class.forName(driver);

            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBUtils getInstance() throws SQLException {
        if(instance == null || instance.getConnection().isClosed()) {
            instance = new DBUtils();
        }
        return instance;
    }
}

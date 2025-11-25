package com.platinum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://192.168.3.100:3306/Cuentas_clientes";
    private static final String USER = "ctacte";
    private static final String PASSWORD = "ctacte2025";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

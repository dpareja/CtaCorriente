package com.platinum;

import org.junit.Test;
import java.sql.Connection;
import static org.junit.Assert.*;

public class DatabaseConnectionTest {
    
    @Test
    public void testConnection() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            assertNotNull("La conexión no debe ser nula", conn);
            assertTrue("La conexión debe estar activa", !conn.isClosed());
            conn.close();
        } catch (Exception e) {
            fail("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}

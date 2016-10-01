package chapter11.memdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Half-implemented authentication manager that works against a simple database table.
 */
public class AuthenticationManager {

    private Connection connection;

    public AuthenticationManager(Connection connection) {
        this.connection = connection;
    }

    public boolean authenticate(String username, String plaintextPassword) {
        try (PreparedStatement ps = connection.prepareStatement("SELECT name, password_hash FROM users");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                String hash = rs.getString("password_hash");

                // Apply some hashing algorithm to the password in plain text and compare it to the hashed value.
                // In reality, there would be no loop. The hashed value would be fed to the SQL query directly.
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}

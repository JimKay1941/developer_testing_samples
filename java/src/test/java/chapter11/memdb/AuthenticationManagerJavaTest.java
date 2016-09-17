package chapter11.memdb;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.Assert.assertTrue;

/**
 * This test isn't in the book. It's the Java counterpart to the book's
 * example in Groovy.
 */
public class AuthenticationManagerJavaTest {

    private static Connection conn;

    @BeforeClass
    public static void setUpOnce() throws Exception {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        conn = DriverManager.getConnection("jdbc:hsqldb:mem:db", "SA", "");
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE users(id BIGINT IDENTITY, " +
                    "name VARCHAR(255), " +
                    "password_hash VARCHAR(255))");
        }
    }

    @Test
    public void successfulAuthentication() throws Exception {
        conn.createStatement().execute(
                "INSERT INTO users (id, name, password_hash) " +
                        "VALUES(NULL, 'joe', '%Gjk!4/P')");

        assertTrue(new AuthenticationManager(conn)
                .authenticate("joe", "secret"));
    }

    @AfterClass
    public static void tearDownOnce() throws Exception {
        conn.createStatement().execute("DROP TABLE users");
    }
}

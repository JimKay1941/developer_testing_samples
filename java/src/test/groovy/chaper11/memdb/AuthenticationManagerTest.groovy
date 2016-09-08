package chaper11.memdb

import chapter11.memdb.AuthenticationManager
import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification

import java.sql.Connection
import java.sql.DriverManager

/**
 * This fast test creates a users table with one user and executes
 * a supposed authentication.
 */
class AuthenticationManagerTest extends Specification {

    @Shared
    private Connection conn

    def setupSpec() {
        Class.forName("org.hsqldb.jdbc.JDBCDriver")
        conn = DriverManager.getConnection("jdbc:hsqldb:mem:db", "SA", "")
        Sql.newInstance(conn).execute(
                "CREATE TABLE users(id BIGINT IDENTITY, " +
                        "name VARCHAR(255), " +
                        "password_hash VARCHAR(255))")
    }

    def "Authenticate user"() {
        given:
        Sql.newInstance(conn).execute("INSERT INTO users " +
                "(id, name, password_hash) VALUES (NULL, 'joe', '%Gjk!4/P')")
        expect:
        new AuthenticationManager(conn).authenticate("joe", "secret")
    }

    /* This wasn't a problem until I included both a Groovy and a Java
    * version of the test, which made the users table persist across the different
    * tests. Ideally, dropping/truncating a table is done during setup, but I
    * didn't want to change the code underlying the printed example.
    */
    def cleanupSpec() {
        Sql.newInstance(conn).execute("DROP TABLE users");
    }
}

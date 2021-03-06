package massimatti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Tietokannan ja sen taulut luova luokka.
 *
 *
 */
public class DatabaseDao {

    private String path;
    private String user;
    private String password;

    /**
     * Luokan konstruktori.
     *
     * @param path config.properties tiedostossa määritelty polku tietokantaan
     * @param user tietokannan käyttäjätunnus
     * @param password tietokannan salasana
     */
    public DatabaseDao(String path, String password, String user) {

        this.path = path;
        this.password = password;
        this.user = user;
    }

    /**
     * Luo tietokannan tauluineen.
     *
     * @throws SQLException tietokannan heittämä poikkeus virhetilanteessa
     */
    public void createDatabase() throws SQLException {
        try {
            Connection conn = DriverManager.
                    getConnection(this.path, this.password, this.user);
            conn.createStatement();
            String createUser = "CREATE TABLE IF NOT EXISTS User ("
                    + "id int AUTO_INCREMENT primary key," + "username VARCHAR(36)," + "password VARCHAR(36))";

            String createEntry = "CREATE TABLE IF NOT EXISTS Entry ("
                    + "id int AUTO_INCREMENT primary key," + "date DATE," + "type BOOLEAN," + "sum DECIMAL(19,2),"
                    + "category VARCHAR(36)," + "userID VARCHAR(36)," + "FOREIGN KEY (userId) REFERENCES User(Username),"
                    + "FOREIGN KEY (category) REFERENCES Category(category));";
            String createCategory = "CREATE TABLE IF NOT EXISTS Category ("
                    + "id int AUTO_INCREMENT primary key," + "category VARCHAR(36))";
            conn.prepareStatement(createUser).execute();
            conn.prepareStatement(createCategory).execute();
            conn.prepareStatement(createEntry).execute();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

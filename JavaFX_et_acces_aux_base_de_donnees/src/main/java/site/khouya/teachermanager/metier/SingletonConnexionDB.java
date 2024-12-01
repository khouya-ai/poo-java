package site.khouya.teachermanager.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {
    private static Connection connection;

    private SingletonConnexionDB() {}

    public static Connection getConnexion() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafxdb", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur de connexion");
            }
        }
        return connection;
    }
}

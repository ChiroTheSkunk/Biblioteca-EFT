package cl.duoc.biblioteca.database;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConnection {
    private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    private final Properties properties = new Properties();
    private DatabaseConnection() {
        try (InputStream in = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (in != null) properties.load(in);
            else { properties.setProperty("url", "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=America/Santiago&useSSL=false&allowPublicKeyRetrieval=true"); properties.setProperty("user", "root"); properties.setProperty("password", ""); }
        } catch (Exception e) { throw new IllegalStateException("No se pudo leer db.properties", e); }
    }
    public static DatabaseConnection getInstance() { return INSTANCE; }
    public Connection getConnection() throws SQLException {
        String url = properties.getProperty("url");
        String user = properties.getProperty("user", "root");
        String password = System.getProperty("biblioteca.db.password", properties.getProperty("password", ""));
        return DriverManager.getConnection(url, user, password);
    }
}

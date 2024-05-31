package erronka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {
    // Establece la conexión con tu base de datos
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/erronkamek";
        String usuario = "root";
        String contraseña = "1WMG2023";
        return DriverManager.getConnection(url, usuario, contraseña);
    }

    // Método para verificar si un usuario existe en la base de datos
    public boolean verificarUsuario(String erabiltzailea, String pasahitza) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM erabiltzaileak WHERE erabiltzailea = ? AND pasahitza = ?")) {
            stmt.setString(1, erabiltzailea);
            stmt.setString(2, pasahitza);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

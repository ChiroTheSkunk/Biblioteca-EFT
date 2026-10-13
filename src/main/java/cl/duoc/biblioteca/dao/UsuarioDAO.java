package cl.duoc.biblioteca.dao;
import cl.duoc.biblioteca.database.DatabaseConnection;
import cl.duoc.biblioteca.model.Usuario;
import java.sql.*;
public class UsuarioDAO {
 public Usuario autenticar(String correo,String clave) throws SQLException {String sql="SELECT id,nombre,correo,rol FROM usuarios WHERE correo=? AND contraseña=?"; try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,correo);p.setString(2,clave);try(ResultSet r=p.executeQuery()){return r.next()?new Usuario(r.getInt("id"),r.getString("nombre"),r.getString("correo"),r.getString("rol")):null;}}}
}

package Service;

import Entity.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private Connection connection; // Conexión a la base de datos

    // Constructor de la clase UsuarioController
    public UsuarioController() throws SQLException {

            // Establece la conexión a la base de datos MySQL
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/crudusuarios", "root", "");

    }

    // Método para crear un nuevo usuario en la base de datos
    public void crearUsuario(Usuario usuario) throws SQLException {
        // Obtiene el nuevo ID disponible para el usuario

        String insertSql = "INSERT INTO Usuarios ( nombre, edad, email) VALUES (?, ?, ?)";
            // Prepara la sentencia SQL para insertar el nuevo usuario en la base de datos
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);
            insertStatement.setString(1, usuario.getNombre());
            insertStatement.setInt(2, usuario.getEdad());
            insertStatement.setString(3, usuario.getEmail());
            insertStatement.executeUpdate(); // Ejecuta la sentencia SQL para insertar el nuevo usuario
            System.out.println("Usuario creado exitosamente.");

    }

    // Método para obtener todos los usuarios almacenados en la base de datos
    public List<Usuario> obtenerUsuarios() throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";

            // Prepara la sentencia SQL para obtener todos los usuarios de la base de datos
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(); // Ejecuta la consulta y obtiene el resultado
            // Itera sobre el resultado y crea objetos Usuario para cada registro
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setEdad(resultSet.getInt("edad"));
                usuario.setEmail(resultSet.getString("email"));
                usuarios.add(usuario); // Agrega el usuario a la lista de usuarios
            }

        return usuarios;
    }

    // Método para obtener el nuevo ID disponible para un nuevo usuario


    // Método para actualizar los datos de un usuario existente en la base de datos
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuarios SET nombre = ?, edad = ?, email = ? WHERE id = ?";

            // Prepara la sentencia SQL para actualizar los datos del usuario
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNombre());
            statement.setInt(2, usuario.getEdad());
            statement.setString(3, usuario.getEmail());
            statement.setInt(4, usuario.getId());
            statement.executeUpdate(); // Ejecuta la sentencia SQL para actualizar los datos del usuario
            System.out.println("Usuario actualizado exitosamente.");

    }

    // Método para eliminar un usuario existente de la base de datos
    public void eliminarUsuario(int id) throws SQLException{
        String deleteSql = "DELETE FROM Usuarios WHERE id = ?";

            // Prepara la sentencia SQL para eliminar el usuario de la base de datos
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate(); // Ejecuta la sentencia SQL para eliminar el usuario
            System.out.println("Usuario eliminado exitosamente.");

    }
}

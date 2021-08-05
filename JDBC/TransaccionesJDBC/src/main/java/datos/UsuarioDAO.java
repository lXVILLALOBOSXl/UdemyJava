package datos;

import domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conexionTransaccional;
    public static final String SQL_SELECT = "SELECT * FROM usuario";
    public static final String SQL_INSERT = "INSERT INTO usuario (usuario, password) VALUES (?, ?)";
    public static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE idUsuario = ?";
    public static final String SQL_DELETE = "DELETE FROM usuario WHERE idUsuario = ?";

    public UsuarioDAO(){}

    public UsuarioDAO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Usuario> seleccionar() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            connection = (this.conexionTransaccional != null) ? this.conexionTransaccional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idUsuario = resultSet.getInt("idUsuario");
                String usuarioColumna = resultSet.getString("usuario");
                String password = resultSet.getString("password");
                usuario = new Usuario(idUsuario, usuarioColumna, password);
                usuarios.add(usuario);
            }
        } finally {
            try {
                Conexion.close(resultSet);
                Conexion.close(preparedStatement);
                if (this.conexionTransaccional == null){
                    Conexion.close(connection);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public int insertar(Usuario usuario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;
        try {
            connection = (this.conexionTransaccional != null) ? this.conexionTransaccional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1,usuario.getUsuario());
            preparedStatement.setString(2, usuario.getPassword());
            registros = preparedStatement.executeUpdate();
        } finally {
            try {
                Conexion.close(preparedStatement);
                if (this.conexionTransaccional == null){
                    Conexion.close(connection);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(Usuario usuario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;
        try {
            connection = (this.conexionTransaccional != null) ? this.conexionTransaccional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1,usuario.getUsuario());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, Integer.toString(usuario.getIdUsuario()));
            registros = preparedStatement.executeUpdate();
        } finally {
            try {
                Conexion.close(preparedStatement);
                if (this.conexionTransaccional == null){
                    Conexion.close(connection);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int eliminar(Usuario usuario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;
        try {
            connection = (this.conexionTransaccional != null) ? this.conexionTransaccional : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setString(1, Integer.toString(usuario.getIdUsuario()));
            registros = preparedStatement.executeUpdate();
        } finally {
            try {
                Conexion.close(preparedStatement);
                Conexion.close(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return registros;
    }
}

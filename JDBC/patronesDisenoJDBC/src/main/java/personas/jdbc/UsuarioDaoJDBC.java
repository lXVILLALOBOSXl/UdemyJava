package personas.jdbc;

import personas.dto.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJDBC implements UsuarioDao {
    private Connection connection;
    public static final String SQL_SELECT = "SELECT * FROM usuario";
    public static final String SQL_INSERT = "INSERT INTO usuario (usuario, password) VALUES (?, ?)";
    public static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE idUsuario = ?";
    public static final String SQL_DELETE = "DELETE FROM usuario WHERE idUsuario = ?";

    public UsuarioDaoJDBC(){}

    public UsuarioDaoJDBC(Connection connection){
        this.connection = connection;
    }

    public List<UsuarioDTO> select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UsuarioDTO usuario = null;
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try {
            connection = (this.connection != null) ? this.connection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idUsuario = resultSet.getInt("idUsuario");
                String usuarioColumna = resultSet.getString("usuario");
                String password = resultSet.getString("password");
                usuario = new UsuarioDTO(idUsuario, usuarioColumna, password);
                usuarios.add(usuario);
            }
        } finally {
            try {
                Conexion.close(resultSet);
                Conexion.close(preparedStatement);
                if (this.connection == null){
                    Conexion.close(connection);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public int insert(UsuarioDTO usuarioDTO) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;
        try {
            connection = (this.connection != null) ? this.connection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1,usuarioDTO.getUsuario());
            preparedStatement.setString(2, usuarioDTO.getPassword());
            registros = preparedStatement.executeUpdate();
        } finally {
            try {
                Conexion.close(preparedStatement);
                if (this.connection == null){
                    Conexion.close(connection);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int update(UsuarioDTO usuarioDTO) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;
        try {
            connection = (this.connection != null) ? this.connection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1,usuarioDTO.getUsuario());
            preparedStatement.setString(2, usuarioDTO.getPassword());
            preparedStatement.setString(3, Integer.toString(usuarioDTO.getIdUsuario()));
            registros = preparedStatement.executeUpdate();
        } finally {
            try {
                Conexion.close(preparedStatement);
                if (this.connection == null){
                    Conexion.close(connection);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(UsuarioDTO usuario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;
        try {
            connection = (this.connection != null) ? this.connection : Conexion.getConnection();
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

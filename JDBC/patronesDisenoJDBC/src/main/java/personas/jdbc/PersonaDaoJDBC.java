package personas.jdbc;

import personas.dto.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoJDBC implements PersonaDao{
    private Connection userConnection;
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? where idPersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona = ?";

    public PersonaDaoJDBC(){}

    public PersonaDaoJDBC(Connection connection){
        this.userConnection = connection;
    }


    @Override
    public int insert(PersonaDTO personaDTO) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int affectedRows = 0;
        try {
            connection = (this.userConnection != null) ? this.userConnection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1,personaDTO.getNombre());
            preparedStatement.setString(2, personaDTO.getApellido());
            preparedStatement.setString(3,personaDTO.getCorreo());
            preparedStatement.setString(4,personaDTO.getTelefono());
            affectedRows = preparedStatement.executeUpdate();
        } finally {
            try {
                Conexion.close(preparedStatement);
                if (this.userConnection == null) {
                    Conexion.close(connection);
                }
            }catch (SQLException throwables){
                throwables.printStackTrace(System.out);
            }
        }
        return affectedRows;
    }

    @Override
    public int update(PersonaDTO personaDTO) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int affectedRows = 0;
        try {
            connection = (this.userConnection != null) ? this.userConnection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1,Integer.toString(personaDTO.getIdPersona()));
            affectedRows = preparedStatement.executeUpdate();
        } finally {
            try {
                Conexion.close(preparedStatement);
                if (this.userConnection == null) {
                    Conexion.close(connection);
                }
            }catch (SQLException throwables){
                throwables.printStackTrace(System.out);
            }
        }
        return affectedRows;
    }

    @Override
    public int delete(PersonaDTO personaDTO) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int affectedRows = 0;
        try {
            connection = (this.userConnection != null) ? this.userConnection : Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1,personaDTO.getNombre());
            preparedStatement.setString(2, personaDTO.getApellido());
            preparedStatement.setString(3,personaDTO.getCorreo());
            preparedStatement.setString(4,personaDTO.getTelefono());
            preparedStatement.setString(5,Integer.toString(personaDTO.getIdPersona()));
            affectedRows = preparedStatement.executeUpdate();
        } finally {
            try {
                Conexion.close(preparedStatement);
                if (this.userConnection == null) {
                    Conexion.close(connection);
                }
            }catch (SQLException throwables){
                throwables.printStackTrace(System.out);
            }
        }
        return affectedRows;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        List<PersonaDTO> personas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        PersonaDTO personaDTO = null;
        try {
            connection = Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idPersona = resultSet.getInt("idPersona");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                String telefono = resultSet.getString("telefono");
                personaDTO = new PersonaDTO(idPersona,nombre,apellido,email,telefono);
                personas.add(personaDTO);
            }
        } finally {
            try {
                Conexion.close(resultSet);
                Conexion.close(preparedStatement);
                if(this.userConnection == null){
                    Conexion.close(connection);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return personas;
    }
}

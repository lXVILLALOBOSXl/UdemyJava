package personas.test;

import personas.dto.PersonaDTO;
import personas.dto.UsuarioDTO;
import personas.jdbc.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestUsuarios {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            if(connection.getAutoCommit()){
                connection.setAutoCommit(false);
            }
            UsuarioDao usuarioDao = new UsuarioDaoJDBC(connection);
            //usuarioDao.insert(new UsuarioDTO("elpepe","2398"));
            List<UsuarioDTO> usuarios = usuarioDao.select();
            usuarios.forEach(usuarioDTO -> {
                System.out.println("Usuario: " + usuarioDTO);
            });
            connection.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Entramos al rollback");
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

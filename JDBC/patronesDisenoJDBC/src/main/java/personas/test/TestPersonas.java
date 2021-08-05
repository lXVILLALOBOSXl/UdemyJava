package personas.test;

import personas.dto.PersonaDTO;
import personas.jdbc.Conexion;
import personas.jdbc.PersonaDao;
import personas.jdbc.PersonaDaoJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestPersonas {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            if(connection.getAutoCommit()){
                connection.setAutoCommit(false);
            }
            PersonaDao personaDao = new PersonaDaoJDBC(connection);
            //personaDao.insert(new PersonaDTO("Carlos","Ramirez","cramirez@mail.com","12736459"));
            List<PersonaDTO> personas = personaDao.select();
            personas.forEach(personaDTO -> {
                System.out.println("Persona: " + personaDTO);
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

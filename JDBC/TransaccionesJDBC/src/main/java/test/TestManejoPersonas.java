package test;

import datos.Conexion;
import datos.PersonaDAO;
import datos.UsuarioDAO;
import domain.Persona;
import domain.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {

        //Objeto para gestionar las acciones en la BD
        /*PersonaDAO personaDAO = new PersonaDAO();*/

        //Insertar un nuevo registro en la base de datos
        /*Persona personaNueva = new Persona("Luis","Villalobos","lvillalobos@mail.com","3313508473");
        personaDAO.insertar(personaNueva);*/

        //Editar la informacion de un registro existente en la BD
        /*Persona personaActualizar = new Persona(3, "Cecilia","Balderrama","cbalderrama@mail.com","1234567890");
        personaDAO.actualizar(personaNueva);*/

        //Eliminar la informacion de un registro existente en la BD
        /*Persona personaElimina = new Persona(4);
        personaDAO.eliminar(personaNueva);*/

        //Guardamos en una lista la consulta de personas
        /*List<Persona> personas = personaDAO.seleccionar();
        //Imprimimos la consulta
        personas.forEach(persona -> {
            System.out.println("Persona: " + persona);
        });*/

        //Pruebas usuarios
        //UsuarioDAO usuarioDAO = new UsuarioDAO();

        //Insertar
        /*Usuario usuario = new Usuario("lxvillaloboxl","hola123");
        usuarioDAO.insertar(usuario);*/

        //Editar
        /*Usuario usuario = new Usuario(1,"LeoScott", "leo123");
        usuarioDAO.actualizar(usuario);*/

        //Eliminar
        /*Usuario usuario = new Usuario(1);
        usuarioDAO.eliminar(usuario);*/

        //Imprimir
        /*List<Usuario> usuarios = usuarioDAO.seleccionar();
        usuarios.forEach(usuario1 -> {
            System.out.println("Usuario: " + usuario1);
        });*/

        //Pruebas manejo de transacciones
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            personaDAO.actualizar(new Persona(2,"Karla Ivonne","Lara","klara@mail.com","5566771122"));
            //personaDAO.insertar(new Persona("Carlos","Ramirez111111111111111111111111111111111111111","cramirez@mail.com","12736459"));
            personaDAO.insertar(new Persona("Carlos","Ramirez","cramirez@mail.com","12736459"));
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }


    }
}

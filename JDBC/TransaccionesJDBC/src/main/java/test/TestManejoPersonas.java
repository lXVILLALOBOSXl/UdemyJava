package test;

import datos.PersonaDAO;
import datos.UsuarioDAO;
import domain.Persona;
import domain.Usuario;

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
        UsuarioDAO usuarioDAO = new UsuarioDAO();

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
        List<Usuario> usuarios = usuarioDAO.seleccionar();
        usuarios.forEach(usuario1 -> {
            System.out.println("Usuario: " + usuario1);
        });

    }
}

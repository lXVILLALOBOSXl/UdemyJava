package main;

import domain.Cliente;
import domain.Empleado;
import domain.Persona;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 'M', 25, "Tulipan Morado #128");
        Empleado empleado1 = new Empleado("Luis", 'M', 20, "Corraleros #612", 10000.00);
        Cliente cliente1 = new Cliente("Cecilia", 'F', 21, "Montilla #1084", new Date(2020,02,01));
        System.out.println("Persona: " + persona1);
        System.out.println("Empleado: " + empleado1);
        System.out.println("Cliente: " + cliente1);
    }
}

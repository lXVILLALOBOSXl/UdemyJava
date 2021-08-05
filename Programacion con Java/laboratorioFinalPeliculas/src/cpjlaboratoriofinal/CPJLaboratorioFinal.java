package cpjlaboratoriofinal;

import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class CPJLaboratorioFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        CatalogoPeliculasImpl catalogo = new CatalogoPeliculasImpl();

        while(opcion != 0){
            System.out.println("Elige una opcion: \n"
                + "1. Iniciar catalogo de peliculas\n"
                    + "2. Agregar pelicula\n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar Pelicula\n"
                + "0. Salir");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    String nombre = scanner.nextLine();
                    catalogo.agregarPelicula(nombre);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la pelicula a buscar");
                    String buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
        }

    }
}

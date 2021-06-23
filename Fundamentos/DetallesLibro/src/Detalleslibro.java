import java.util.Scanner;

public class Detalleslibro {
    public static void main(String args[]){
        Scanner consola = new Scanner(System.in);
        System.out.println("Proporciona el titulo: ");
        var titulo = consola.nextLine();
        System.out.println("Proporciona el autor: ");
        var autor = consola.nextLine();
        System.out.println(titulo + " fue escrito por " + autor);

    }
}

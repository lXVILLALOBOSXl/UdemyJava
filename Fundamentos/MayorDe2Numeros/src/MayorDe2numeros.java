import java.util.Scanner;

public class MayorDe2numeros {
    public static void main(String args[]){
        var consola = new Scanner(System.in);
        System.out.println("Proporciona el numero1: ");
        int numero1 = Integer.parseInt(consola.nextLine());
        System.out.println("Proporciona el numero2: ");
        int numero2 = Integer.parseInt(consola.nextLine());
        var mayorNumero = (numero1 >= numero2) ? numero1 : numero2;
        System.out.println("El mayor numero es: " + mayorNumero);
    }
}
import java.util.Scanner;

public class Rectangulo {
    public static void main(String args[]){
        var consola = new Scanner(System.in);
        System.out.println("Proporciona el alto: ");
        int alto = Integer.parseInt(consola.nextLine());
        System.out.println("Proporciona el ancho: ");
        int ancho = Integer.parseInt(consola.nextLine());
        int area = ancho*alto;
        int perimetro = (2*alto)+(2*ancho);
        System.out.println("Area: " + area);
        System.out.println("Perimetro: " + perimetro);
    }
}
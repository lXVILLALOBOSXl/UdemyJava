import java.util.Scanner;

public class Calificaciones {
    public static void main(String args[]){
        var consola = new Scanner(System.in);
        String nota = "Valor desconocido";
        System.out.println("Proporciona un valor entre 0 y 10: ");
        double calificacion = Double.parseDouble(consola.nextLine());
        if(calificacion >= 9D && calificacion <= 10D){
            nota = "A";
        }else if(calificacion >= 8D && calificacion < 9D){
            nota = "B";
        }else if(calificacion >= 7D && calificacion < 8D){
            nota = "C";
        }else if(calificacion >= 6D && calificacion < 7D){
            nota = "D";
        }else if(calificacion >= 0D && calificacion < 6D){
            nota = "F";
        }
        System.out.println(nota);
    }
}

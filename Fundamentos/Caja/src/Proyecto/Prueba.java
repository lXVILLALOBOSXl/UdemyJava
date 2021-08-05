package Proyecto;

public class Prueba {
    public static void main(String[] args) {
        Caja caja1 = new Caja(3,2,6);
        Caja caja2 = new Caja();
        System.out.println(caja1.calcularVolumen());
    }
}

package Proyecto;

public class Caja {
    int ancho;
    int alto;
    int largo;

    Caja(){
        System.out.println("Creando Objeto...");
    }

    Caja(int ancho, int alto, int largo){
        this.ancho = ancho;
        this.largo = largo;
        this.alto = alto;
    }

    public int calcularVolumen(){
        return this.ancho * this.alto * this.largo;
    }
}

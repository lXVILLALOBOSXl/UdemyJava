package com.gm.mundopc;

public class Orden {
    private final int idOrden;
    private Computadora computadoras[];
    private int contadorComputadoras;
    private static int contadorOrdenes;
    private static final int MAX_COMPUTADORAS = 10;

    public Orden(){
        this.idOrden = ++contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
    }

    public void agregarComputadora(Computadora computadora){
        if(this.contadorComputadoras < Orden.MAX_COMPUTADORAS){
                this.computadoras[this.contadorComputadoras++] = computadora;
        }else{
            System.out.println("Ha excedido el numero Maximo: " + Orden.MAX_COMPUTADORAS + " de computadoras que se pueden agregar a una orden");
        }
    }

    public void mostrarOrden(){
        System.out.println("id De la orden: " + this.idOrden);
        for (int i = 0; i < this.contadorComputadoras; i++) {
            System.out.println(this.computadoras[i].toString());
        }
    }
}

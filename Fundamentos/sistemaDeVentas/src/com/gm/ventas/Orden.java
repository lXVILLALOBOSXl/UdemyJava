package com.gm.ventas;

public class Orden {
    private int idOrden;
    private Producto productos[];
    private static int contadorOrdenes;
    private static final int MAX_PRODUCTOS = 10;
    private int contadorProductos;

    public Orden(){
        this.idOrden = ++contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    }

    public void agregarProducto(Producto producto){
        if(this.contadorProductos < Orden.MAX_PRODUCTOS){
            this.productos[this.contadorProductos++] = producto;
        }else{
            System.out.println("Limite de productos excedido usted ya cuenta con: " + this.productos.length + " productos.");
        }
    }

    public double calcularTotal(){
        double total = 0d;
        for (int i = 0; i < this.contadorProductos; i++){
            total += this.productos[i].getPrecio();
        }
        return total;
    }

    public void  mostrarOrden(){
        System.out.println("id Orden: " + this.idOrden);
        for (int i = 0; i < this.contadorProductos; i++){
            System.out.println(this.productos[i]);
        }
        System.out.println("Total: " + this.calcularTotal() + "$");
    }
}

package ventas;

import com.gm.ventas.*;

public class Ventas {
    public static void main(String[] args) {
        Orden orden1 = new Orden();
        orden1.agregarProducto(new Producto("Jugo",20));
        orden1.agregarProducto(new Producto("Sabritas",15));
        orden1.mostrarOrden();
    }
}

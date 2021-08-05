package mundopc;

import com.gm.mundopc.*;

public class MundoPc {
    public static void main(String[] args) {
        Orden orden1 = new Orden();
        orden1.agregarComputadora(new Computadora("MacBook Pro", new Monitor("Apple",13), new Teclado("Bluetooth","Apple"), new Raton("Bluetooth","Apple")));
        orden1.agregarComputadora(new Computadora("Aspire", new Monitor("Acer",15), new Teclado("Bluetooth","Logitech"), new Raton("Bluetooth","BlueFinger")));
        orden1.mostrarOrden();
    }
}

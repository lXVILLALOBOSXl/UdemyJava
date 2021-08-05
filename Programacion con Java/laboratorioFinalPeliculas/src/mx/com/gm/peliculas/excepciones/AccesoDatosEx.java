package mx.com.gm.peliculas.excepciones;

import mx.com.gm.peliculas.datos.AccesoDatos;

public class AccesoDatosEx extends Exception{
    public AccesoDatosEx(String mensaje){
        super(mensaje);
    }
}

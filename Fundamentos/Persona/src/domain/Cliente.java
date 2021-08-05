package domain;

import java.util.Date;

public class Cliente extends Persona{
    private int idCliente;
    private Date fechaRegistro;
    private static int idContador;

    public Cliente(String nombre, char genero, int edad, String direccion, Date fechaRegistro) {
        super(nombre, genero, edad, direccion);
        this.idCliente = ++Cliente.idContador;
        this.fechaRegistro = fechaRegistro;
    }

    public Cliente(int idCliente, Date fechaRegistro) {
        this.idCliente =  ++Cliente.idContador;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public static int getIdContador() {
        return idContador;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", fechaRegistro=" + fechaRegistro +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", idPersona=" + idPersona +
                '}';
    }
}

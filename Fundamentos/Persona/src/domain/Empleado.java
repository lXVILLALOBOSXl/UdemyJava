package domain;

public class Empleado extends Persona{
    private int idEmpleado;
    private double sueldo;
    private static int idContador;

    public Empleado(String nombre, char genero, int edad, String direccion, double sueldo) {
        super(nombre, genero, edad, direccion);
        this.idEmpleado = ++Empleado.idContador;
        this.sueldo = sueldo;
    }

    public Empleado(int idEmpleado, double sueldo) {
        this.idEmpleado = ++Empleado.idContador;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public static int getIdContador() {
        return idContador;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", sueldo=" + sueldo +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", idPersona=" + idPersona +
                '}';
    }
}

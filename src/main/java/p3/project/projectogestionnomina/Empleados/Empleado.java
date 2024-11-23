package p3.project.projectogestionnomina.Empleados;

import p3.project.projectogestionnomina.CONST;

import java.util.Date;
import java.util.Random;

public class Empleado {
    private String ID;
    private String Cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String correo;
    private String telefono;
    private String puesto;
    private double SueldoBase;
    private Date FechaIngreso;
    private CuentaBancaria cuenta;

    public Empleado() {
    }

    public Empleado(String nombre, int edad, String puesto) {
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
    }


    public Empleado(String Cedula, String nombre, String apellido, int edad, String sexo, String correo, String telefono, String puesto, double sueldoBase, Date fechaIngreso) {
        this.Cedula = Cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
        this.telefono = telefono;
        this.puesto = puesto;
        SueldoBase = sueldoBase;
        FechaIngreso = fechaIngreso;
    }

    public Empleado(Empleado empleado) {
    this.ID = empleado.ID;
    this.Cedula = empleado.Cedula;
    this.nombre = empleado.nombre;
    this.apellido = empleado.apellido;
    this.edad = empleado.edad;
    this.sexo = empleado.sexo;
    this.correo = empleado.correo;
    this.telefono = empleado.telefono;
    this.puesto = empleado.puesto;
    SueldoBase = empleado.SueldoBase;
    FechaIngreso = empleado.FechaIngreso;
    CuentaBancaria cuenta = empleado.cuenta;
    this.cuenta = cuenta;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public boolean AsignarCuentaBancaria() {
        if (cuenta == null) {
            Random r = new Random();
            String numCuenta = "" + r.nextInt(0, 10) + r.nextInt(0, 10) + r.nextInt(0, 10) + r.nextInt(0, 10) + r.nextInt(0, 10) + r.nextInt(0, 10) + r.nextInt(0, 10) + r.nextInt(0, 10) + r.nextInt(0, 10) + r.nextInt(0, 10);

            cuenta = new CuentaBancaria("Cuenta de Ahorros",numCuenta,"DOP",this.ID);
            return true;
        } else
            return false;

    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSueldoBase() {
        return Double.parseDouble(String.format("%.2f", SueldoBase));
    }

    public void setSueldoBase(double sueldoBase) {
        SueldoBase = sueldoBase;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getARS() {
        return Double.parseDouble(String.format("%.2f",(getSueldoBase() * CONST.ARS / 100)));
    }

    public double getAFP() {
        return Double.parseDouble(String.format("%.2f",(getSueldoBase() * CONST.AFP / 100)));
    }

    public double getIRS() {
        double impuesto = 0.0;

        if (getSueldoBase() <= 416220) {
            impuesto = 0.0; // Exento
        } else if (getSueldoBase() > 416220 && getSueldoBase() <= 624329) {
            // 15% del excedente de RD$416,220.01
            impuesto = (getSueldoBase() - 416220) * 0.15;
        } else if (getSueldoBase() > 624329 && getSueldoBase() <= 867123) {
            // RD$31,216 más el 20% del excedente de RD$624,329.01
            impuesto = 31216 + (getSueldoBase() - 624329) * 0.20;
        } else if (getSueldoBase() > 867123) {
            // RD$79,776 más el 25% del excedente de RD$867,123.01
            impuesto = 79776 + (getSueldoBase() - 867123) * 0.25;
        }

        return Double.parseDouble(String.format("%.2f",impuesto));
    }


    public double getSueldoNeto() {
        return Double.parseDouble(String.format("%.2f",getSueldoBase() - (getAFP() + getARS() + getIRS())));
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", puesto='" + puesto + '\'' +
                ", SueldoBase=" + String.format("%.2f", SueldoBase) +
                '}';
    }
}

package p3.project.projectogestionnomina.GestorNomina;

import p3.project.projectogestionnomina.Empleados.Empleado;

import java.util.ArrayList;
import java.util.List;

public class Nomina {

    private List<Empleado> empleados;

    public Nomina() {
        empleados = new ArrayList<Empleado>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void AgregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void AgregarVariosEmpleados(List<Empleado> empleados) {
        if (empleados != null) {
            if (empleados.size() > 0) {
                this.empleados.addAll(empleados);
            }
        }
    }

    public void EliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public String Mostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append("|\tID\t|\tNOMBRE\t|\tNUMERO DE CUENTA\t|\tSUELDO BASE\t|\tDEDUCCIONES\t|\tNETO\n");
        for (Empleado empleado : empleados) {
            double deducciones = empleado.getIRS() + empleado.getAFP() + empleado.getARS();
            sb.append(empleado.getID() + ",\t" + empleado.getNombre() + " " + empleado.getApellido() + ",\t" + empleado.getCuenta().getNumeroCuenta() + ",\t" + String.format("%.2f", empleado.getSueldoBase() )+ ",\t"+String.format("%.2f", deducciones)+",\t"+String.format("%.2f", empleado.getSueldoNeto())+"\n");
        }
        if (sb.toString().isEmpty()) {
            return "Nothing here";
        }
        return sb.toString();
    }

    public double TotalAPagar() {
        double total = 0;
        for (Empleado empleado : empleados) {
            total += empleado.getSueldoBase();
        }
        return total;
    }
}

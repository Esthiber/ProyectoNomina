package p3.project.projectogestionnomina.Empleados;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
    List<Empleado> empleados;
    private int LastID;

    public GestorEmpleados() {
        empleados = new ArrayList<Empleado>();
        LastID = 0;
    }

    public GestorEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public boolean addEmpleado(Empleado empleado) {

        if( empleado.getID() == null || empleado.getID().isEmpty()){
            StringBuilder sb = new StringBuilder();
          int size =  String.valueOf(++LastID).length();
          for(int i = 0; i<5-size;i++){
              sb.append("0");
          }
          sb.append(LastID);
          empleado.setID(sb.toString());
        }
       else{
           int empID=Integer.parseInt(empleado.getID());
           if( empID> LastID){
               LastID = empID;
           }
        }

        return empleados.add(empleado);
    }

    public boolean removeEmpleado(Empleado empleado) {
        return empleados.remove(empleado);
    }

    public boolean removeEmpleado(String empID) {
        for(Empleado e : empleados){
            if(e.getID().equals(empID)){
                return empleados.remove(e);
            }
        }
        return false;
    }

    public Empleado getEmpleado(int index) {
        return empleados.get(index);
    }

    public Empleado getEmpleado(String ID) {
        for (Empleado empleado : empleados) {
            if (empleado.getID().equals(ID)) {
                return empleado;
            }
        }
        return null;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        for(Empleado e : empleados)this.addEmpleado(e);

    }

    public void listarEmpleados() {
        if (empleados == null || empleados.isEmpty()) {
            System.out.println("No hay empleados para listar.");
        } else {
            empleados.forEach(System.out::println);
        }
    }
}

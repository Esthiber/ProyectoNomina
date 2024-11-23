package p3.project.projectogestionnomina.GestorBaseDatos;

import p3.project.projectogestionnomina.CONST;
import p3.project.projectogestionnomina.Empleados.CuentaBancaria;
import p3.project.projectogestionnomina.Empleados.Empleado;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos<T> {
    private String FILE_PATH; // Ruta del archivo JSON
    private final Class<T> type;

    /* Es necesario obtener el tipo de la lista para hacer un correcto casteo al leerlo del json */
    public BaseDatos(String DBFileName, Class<T> type) {
        String directory = "Data";
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        this.FILE_PATH = directory + File.separator + DBFileName;
        this.type = type;
    }

    // Metodo para guardar la lista de empleados en un archivo JSON
    public boolean Guardar(List<T> emp) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String json = gson.toJson(emp);
            writer.write(json);
            writer.close();
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + FILE_PATH);
            e.printStackTrace();
            return false;
        }
    }

    public List<T> Leer() {
        Gson gson = new Gson();
        List<T> elems = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Type listType = TypeToken.getParameterized(List.class, type).getType();
            elems = gson.fromJson(reader, listType);
            if (elems == null) {
                elems = new ArrayList<>();
            }
        } catch (IOException e) {

            System.err.println("Error reading from file: " + FILE_PATH);
            // e.printStackTrace();
        }
        return elems;
    }

    public boolean GuardarPopular(CuentaBancaria cuentaOrigen, List<Empleado> emps) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean GuardarBHD(CuentaBancaria cuentaOrigen, List<Empleado> emps) {
        // Ruta del directorio y archivo
        String directorio = "Exportaciones";
        String archivo = directorio + File.separator + CONST.EXPORT_BHD;

        File dir = new File(directorio);    // Crear directorio si no existe
        if (!dir.exists() && !dir.mkdirs()) {
            System.err.println("No se pudo crear el directorio: " + directorio);
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (Empleado emp : emps) {
            CuentaBancaria cuenta = emp.getCuenta();
            // Formato: CUENTA; NOMBRECOMPLETO;REF;MONTO;CONCEPTO
            sb.append(
                            cuenta.getNumeroCuenta() + ";" +
                            emp.getNombre() + " " + emp.getApellido() + ";"+
                            emp.getID()+";"   +
                            String.format("%.2f",emp.getSueldoNeto()).replace(".","")+";"+
                            "Pago Nomina"
                    );
            sb.append("\n");
        }

        // Escritura en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(sb.toString());
            System.out.println("Archivo exportado exitosamente en: " + archivo);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ocurrio un error al escribir el archivo. Se le abrio el pecho, que se yo.");
            return false;
        }
    }

    public boolean GuardarBanReservas(CuentaBancaria cuentaOrigen, List<Empleado> emps) {
        // Ruta del directorio y archivo
        String directorio = "Exportaciones";
        String archivo = directorio + File.separator + CONST.EXPORT_BANRESERVAS;

        File dir = new File(directorio);    // Crear directorio si no existe
        if (!dir.exists() && !dir.mkdirs()) {
            System.err.println("No se pudo crear el directorio: " + directorio);
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (Empleado emp : emps) {
            sb.append(
                    cuentaOrigen.AbreviarTipoCuenta() + "," +
                            cuentaOrigen.getMoneda() + "," +
                            cuentaOrigen.getNumeroCuenta() + "," +
                            emp.getCuenta().AbreviarTipoCuenta() + "," +
                            emp.getCuenta().getMoneda() + "," +
                            emp.getCuenta().getNumeroCuenta() + "," +
                            String.format("%.2f", emp.getSueldoNeto()) + "," +  // Formato de dos decimales
                            "NOMINA");
            sb.append("\n");
        }

        // Escritura en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(sb.toString());
            System.out.println("Archivo exportado exitosamente en: " + archivo);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ocurrio un error al escribir el archivo. Se le abrio el pecho, que se yo.");
            return false;
        }
    }
}

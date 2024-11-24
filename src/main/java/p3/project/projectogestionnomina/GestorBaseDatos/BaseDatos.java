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
    private final String FILE_PATH; // Ruta del archivo JSON
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
            System.err.println(e.getMessage());
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
        if (cuentaOrigen == null) return false;
        // Ruta del directorio y archivo
        String directorio = "Exportaciones";
        String archivo = directorio + File.separator + CONST.EXPORT_POPULAR;

        // Crear directorio si no existe
        File dir = new File(directorio);
        if (!dir.exists() && !dir.mkdirs()) {
            System.err.println("No se pudo crear el directorio: " + directorio);
            return false;
        }

        // Construir el contenido del archivo según el layout
        StringBuilder sb = new StringBuilder();

        // **Encabezado**
        sb.append("H"); // Tipo de registro (Header)
        sb.append(String.format("%-15s", CONST.COMPANY_ID)); // ID de la compañía (RNC)
        sb.append(String.format("%-35s", CONST.COMPANY_NAME)); // Nombre de la compañía
        sb.append(String.format("%07d", CONST.HEADER_SEQUENCE)); // Secuencia del header
        sb.append("01"); // Tipo de servicio (01 = Nómina automática)
        sb.append(CONST.EFFECTIVE_DATE); // Fecha efectiva (YYYYMMDD)
        sb.append(String.format("%011d", emps.size())); // Cantidad de créditos
        sb.append(String.format("%013d", convertirMonto(calcularTotalNeto(emps)))); // Monto total de créditos
        sb.append("00000000000"); // Cantidad de débitos (n/a)
        sb.append("0000000000000"); // Monto total de débitos (n/a)
        sb.append("000000000000000"); // Número de afiliación a CARDNET (n/a)
        sb.append(CONST.SEND_DATE); // Fecha de envío (YYYYMMDD)
        sb.append(CONST.SEND_TIME); // Hora de envío (HHMM)
        sb.append(String.format("%-40s", CONST.EMAIL)); // Email
        sb.append(" "); // Estatus (en blanco)
        sb.append(String.format("%-136s", "")); // Filler (espacios en blanco)
        sb.append("\n");

        // **Detalles**
        int secuenciaTransaccion = 1;
        for (Empleado emp : emps) {
            CuentaBancaria cuenta = emp.getCuenta();

            // Tipo de registro (Detalle)
            sb.append("N");

            // ID de la compañía
            sb.append(String.format("%-15s", CONST.COMPANY_ID));

            // Secuencia del header
            sb.append(String.format("%07d", CONST.HEADER_SEQUENCE));

            // Secuencia de la transacción
            sb.append(String.format("%07d", secuenciaTransaccion++));

            // Cuenta destino
            sb.append(String.format("%-20s", cuenta.getNumeroCuenta()));

            // Tipo de cuenta destino
            sb.append("1"); // (Ejemplo: 1 = Corriente)

            // Moneda destino
            sb.append("214"); // RD$

            // Código del banco destino
            sb.append("10101070"); // Banco Popular

            // Dígito verificador del banco destino
            sb.append("8");

            // Código de operación
            sb.append("22"); // Crédito a cuenta corriente

            // Monto de la transacción
            sb.append(String.format("%013d", convertirMonto(emp.getSueldoNeto())));

            // Tipo de identificación (RNC)
            sb.append("RN");

            // Identificación
            sb.append(String.format("%-15s", emp.getID()));

            // Nombre del beneficiario
            sb.append(String.format("%-35s", emp.getNombre() + " " + emp.getApellido()));

            // Número de referencia
            sb.append(String.format("%-12s", emp.getID()));

            // Descripción
            sb.append(String.format("%-40s", "Pago Nómina"));

            // Filler
            sb.append(String.format("%-134s", ""));

            sb.append("\n");
        }

        // Guardar el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(sb.toString());
            System.out.println("Archivo exportado exitosamente en: " + archivo);
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Ocurrio un error al escribir el archivo.");
            return false;
        }
    }

    public boolean GuardarBHD(CuentaBancaria cuentaOrigen, List<Empleado> emps) {

        if (cuentaOrigen == null)
            return false;

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
            sb.append(cuenta.getNumeroCuenta()).append(";").append(emp.getNombre()).append(" ").append(emp.getApellido()).append(";").append(emp.getID()).append(";").append(String.format("%.2f", emp.getSueldoNeto()).replace(".", "")).append(";").append("Pago Nomina");
            sb.append("\n");
        }

        // Escritura en el archivo
        return fileWriter(archivo, sb);
    }

    private boolean fileWriter(String archivo, StringBuilder sb) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(sb.toString());
            System.out.println("Archivo exportado exitosamente en: " + archivo);
            writer.close();
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
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
            sb.append(cuentaOrigen.AbreviarTipoCuenta()).append(",").append(cuentaOrigen.getMoneda()).append(",").append(cuentaOrigen.getNumeroCuenta()).append(",").append(emp.getCuenta().AbreviarTipoCuenta()).append(",").append(emp.getCuenta().getMoneda()).append(",").append(emp.getCuenta().getNumeroCuenta()).append(",").append(String.format("%.2f", emp.getSueldoNeto())).append(",").append(  // Formato de dos decimales
                    "NOMINA");
            sb.append("\n");
        }

        // Escritura en el archivo
        return fileWriter(archivo, sb);
    }

    private double calcularTotalNeto(List<Empleado> emps) {
        double sum = 0;
        for (Empleado emp : emps) {
            sum += emp.getSueldoNeto();
        }
        return sum;
    }

    private int convertirMonto(double monto) {
        return (int) Math.round(monto * 100); // Multiplica por 100 para eliminar los decimales
    }
}

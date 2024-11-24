package p3.project.projectogestionnomina;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import p3.project.projectogestionnomina.Empleados.CuentaBancaria;
import p3.project.projectogestionnomina.Empleados.Empleado;
import p3.project.projectogestionnomina.Empleados.GestorEmpleados;
import p3.project.projectogestionnomina.GestorBaseDatos.BaseDatos;
import p3.project.projectogestionnomina.GestorNomina.Nomina;
import p3.project.projectogestionnomina.Interacciones.Sys;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Nomina");
        stage.setScene(scene);
        stage.show();
    }

    // Variables compartidas
    private static GestorEmpleados ges;
    private static Nomina nomina;
    private static BaseDatos<Empleado> bd_empleados;
    private static BaseDatos<CuentaBancaria> bd_cuentas;
    private static List<CuentaBancaria> cuentasDeBanco;

    public static void main(String[] args) throws IOException {
        launch(args);

        System.exit(0);// Cambiamos de CLI a FXML, ?se escribia asi?

        // Inicialización
        ges = new GestorEmpleados();
        nomina = new Nomina();
        bd_empleados = new BaseDatos<>(CONST.BD_Empleados, Empleado.class);
        bd_cuentas = new BaseDatos<>(CONST.BD_CuentasBancarias, CuentaBancaria.class);

        // Carga inicial de datos // Todo Meterlo todo en una funcion
        cargarDatos();

        // Inicio del sistema   // TODO meterlo en una funcion modular
        iniciarSistema();
    }

    private static void cargarDatos() {
        ges.setEmpleados(bd_empleados.Leer());
        cuentasDeBanco = bd_cuentas.Leer();

        /* Carga las cuentas de banco del archivo y luego se las asigna a su respectivo empleado.*/
        if (!cuentasDeBanco.isEmpty()) {
            for (CuentaBancaria c : cuentasDeBanco) {
                for (Empleado empleado : ges.getEmpleados()) {
                    if (empleado.getID().equals(c.getIDPropietario())) {
                        empleado.setCuenta(c);
                    }
                }
            }
        }
    }

    private static void iniciarSistema() throws IOException {
        int opt;
        do {
            opt = Sys.Menu(new String[]{"Empleados", "Nomina", "Salir"});
            switch (opt) {
                case 1: /// Sub Seccion de Empleados
                    menuEmpleados();
                    break;
                case 2: /// Sub Seccion de Nomina
                    menuNomina();
                    break;
                case 3: /// Salirse del sitema y burlarse de el.
                    Sys.Mensaje("Saliendo del sistema...");
                    break;
                default:
                    Sys.Mensaje("Opcion incorrecta, intente nuevamente.");
            }
        } while (opt != 3);
    }

    private static void menuEmpleados() throws IOException {
        Sys.Titulo("Empleado");
        int opcion;
        do {
            opcion = Sys.Menu(new String[]{"Mostrar", "Agregar", "Buscar", "Volver"});
            switch (opcion) {
                case 1: /// Mostrar lista de empleados
                    ges.listarEmpleados();
                    break;
                case 2: /// Agregar Empleado
                    agregarEmpleado();
                    break;
                case 3:/// Buscar Empleado
                    buscarEmpleado();
                    break;
                case 4: /// Volver
                    return;
                default:
                    Sys.Mensaje("Opcion incorrecta, intente nuevamente.");
            }
        } while (true);
    }

    private static void agregarEmpleado() throws IOException {
        Empleado e = Sys.NuevoEmpleado();
        ges.addEmpleado(e);
        if (e.getCuenta() != null && e.getCuenta().getIDPropietario() != null && e.getCuenta().getIDPropietario().isEmpty()) {
        } else {
            for (CuentaBancaria cuenta : cuentasDeBanco) {
                if (cuenta.getIDPropietario().equals(e.getID())) {
                    cuentasDeBanco.add(e.getCuenta());
                }
            }
            if (e.getCuenta() == null) e.AsignarCuentaBancaria();
        }


        boolean guardadoEmpleados = bd_empleados.Guardar(ges.getEmpleados());
        boolean guardadoCuentas = bd_cuentas.Guardar(cuentasDeBanco);

        if (guardadoEmpleados && guardadoCuentas) {
            Sys.Mensaje("Empleado y cuenta guardados satisfactoriamente!");
        } else {
            Sys.Mensaje("Ocurrio un error al guardar el empleado o la cuenta.");
        }
    }

    private static void buscarEmpleado() throws IOException {
        String id = Sys.PedirInput("Ingrese el ID del empleado:");
        Empleado empleado = ges.getEmpleado(id);
        if (empleado != null) {
            Sys.Mensaje("Empleado encontrado:\n" + empleado);
        } else {
            Sys.Mensaje("No se encontró un empleado con ese ID.");
        }
    }

    private static void menuNomina() throws IOException {
        Sys.Titulo("Nómina");
        int opcion;
        do {
            opcion = Sys.Menu(new String[]{"Mostrar", "Exportar", "Volver"});
            switch (opcion) {
                case 1:/// Mostrar
                    mostrarNomina();
                    break;
                case 2:/// Exportar
                    exportarNomina();
                    break;
                case 3:/// Volver
                    return;
                default:
                    Sys.Mensaje("Opción incorrecta, intente nuevamente.");
            }
        } while (true);
    }

    private static void mostrarNomina() throws IOException {
        if ((nomina.getEmpleados().isEmpty() && !ges.getEmpleados().isEmpty()) ||
                nomina.getEmpleados().size() < ges.getEmpleados().size()) {
            nomina.AgregarVariosEmpleados(ges.getEmpleados());
        }
        Sys.Mensaje(nomina.Mostrar());
        Sys.Wait("Pulse \"Enter\" para continuar.");
    }

    private static void exportarNomina() throws IOException {
        int opcionBanco = Sys.Menu(new String[]{"BanReservas", "Popular", "BHD León", "Cancelar"});
        switch (opcionBanco) {
            case 1:
                bd_empleados.GuardarBanReservas(CONST.CUENTA_ORIGEN, ges.getEmpleados());
                break;
            case 2:
                // TODO Logica para Popular
                Sys.Mensaje("No desarrollada aun...");
                break;
            case 3:
                // TODO Logica para BHD León
                bd_empleados.GuardarBHD(CONST.CUENTA_ORIGEN,ges.getEmpleados());
                break;
            case 4:/// Cancelare
                return;
            default:
                Sys.Mensaje("Opción incorrecta.");
        }
    }
}



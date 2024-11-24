package p3.project.projectogestionnomina;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import p3.project.projectogestionnomina.Empleados.CuentaBancaria;
import p3.project.projectogestionnomina.Empleados.Empleado;
import p3.project.projectogestionnomina.Empleados.GestorEmpleados;
import p3.project.projectogestionnomina.GestorBaseDatos.BaseDatos;
import p3.project.projectogestionnomina.GestorNomina.Nomina;
import p3.project.projectogestionnomina.Interacciones.Sys;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class MainController {
    private static GestorEmpleados gestorEmpleados;
    private static Nomina nomina;
    private static BaseDatos<Empleado> bd_empleados;
    private static BaseDatos<CuentaBancaria> bd_cuentas;
    private static List<CuentaBancaria> cuentasDeBanco;


    // Lista Empleados
    private ObservableList<Empleado> empleadosObservableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Empleado, String> colNombreEmpleado;
    @FXML
    private TableColumn<Empleado, String> colApellidoEmpleado;
    @FXML
    private TableColumn<Empleado, String> colIdEmpleado; // Cedula
    @FXML
    private TableColumn<Empleado, String> colPuesto;
    @FXML
    private TableColumn<Empleado, Double> colSalarioEmpleado;
    @FXML
    private TableColumn<Empleado, Integer> colEdadEmpleado;


    // Lista Nomina
    private ObservableList<Empleado> nominaObservableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Empleado, String> colNombreNom;
    @FXML
    private TableColumn<Empleado, String> colApellidoNom;
    @FXML
    private TableColumn<Empleado, String> colIdNom;
    @FXML
    private TableColumn<Empleado, String> colPuestoNom;
    @FXML
    private TableColumn<Empleado, Double> colSalarioNom;
    @FXML
    private TableColumn<Empleado, Double> colIRS;
    @FXML
    private TableColumn<Empleado, Double> colARS;
    @FXML
    private TableColumn<Empleado, Double> colAFP;
    @FXML
    private TableColumn<Empleado, Double> colSalarioNeto;

    @FXML
    private void initialize() {
        // Inicialización
        gestorEmpleados = new GestorEmpleados();
        nomina = new Nomina();
        bd_empleados = new BaseDatos<>(CONST.BD_Empleados, Empleado.class);
        bd_cuentas = new BaseDatos<>(CONST.BD_CuentasBancarias, CuentaBancaria.class);

        InicializarTablaEmpleados();
        InicializarTablaNomina();

        cargarDatos();
        RecargarEmpleado_OnAction(new ActionEvent());
        RecargarNomina_OnAction(new ActionEvent());
    }

    private static void cargarDatos() {
        gestorEmpleados.setEmpleados(bd_empleados.Leer());
        nomina.AgregarVariosEmpleados(gestorEmpleados.getEmpleados());
        cuentasDeBanco = bd_cuentas.Leer();
    }

    void InicializarTablaEmpleados() {
        colIdEmpleado = new TableColumn<>("ID");
        colIdEmpleado.setCellValueFactory(new PropertyValueFactory<>("ID"));

        colNombreEmpleado = new TableColumn<>("Nombre");
        colNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        colApellidoEmpleado = new TableColumn<>("Apellido");
        colApellidoEmpleado.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        colEdadEmpleado = new TableColumn<>("Edad");
        colEdadEmpleado.setCellValueFactory(new PropertyValueFactory<>("edad"));

        colSalarioEmpleado = new TableColumn<>("Salario");
        colSalarioEmpleado.setCellValueFactory(new PropertyValueFactory<>("SueldoBase"));

        colPuesto = new TableColumn<>("Puesto");
        colPuesto.setCellValueFactory(new PropertyValueFactory<>("puesto"));

        TableEmpleado.setItems(empleadosObservableList);
        TableEmpleado.getColumns().addAll(colIdEmpleado, colNombreEmpleado, colApellidoEmpleado, colEdadEmpleado, colPuesto, colSalarioEmpleado);


    }

    void InicializarTablaNomina() {

        colNombreNom = new TableColumn<>("Nombre");
        colNombreNom.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoNom = new TableColumn<>("Apellido");
        colApellidoNom.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colIdNom = new TableColumn<>("ID");
        colIdNom.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colPuestoNom = new TableColumn<>("Puesto");
        colPuestoNom.setCellValueFactory(new PropertyValueFactory<>("puesto"));
        colSalarioNom = new TableColumn<>("Salario");
        colSalarioNom.setCellValueFactory(new PropertyValueFactory<>("SueldoBase"));

        colIRS = new TableColumn<>("IRS");
        colIRS.setCellValueFactory(new PropertyValueFactory<>("IRS"));

        colARS = new TableColumn<>("ARS");
        colARS.setCellValueFactory(new PropertyValueFactory<>("ARS"));

        colAFP = new TableColumn<>("AFP");
        colAFP.setCellValueFactory(new PropertyValueFactory<>("AFP"));

        colSalarioNeto = new TableColumn<>("Neto");
        colSalarioNeto.setCellValueFactory(new PropertyValueFactory<>("SueldoNeto"));

        TableNomina.setItems(nominaObservableList);
        TableNomina.getColumns().addAll(colIdNom, colNombreNom, colApellidoNom, colPuestoNom, colSalarioNom, colIRS, colAFP, colARS, colSalarioNeto);
    }

    @FXML
    private TableView<Empleado> TableEmpleado;

    @FXML
    private TableView<Empleado> TableNomina;

    @FXML
    private TextField tf_Apellido;

    @FXML
    private TextField tf_Correo;

    @FXML
    private TextField tf_Edad;

    @FXML
    private TextField tf_ID;

    @FXML
    private TextField tf_IDEliminar;

    @FXML
    private TextField tf_Nombre;

    @FXML
    private TextField tf_Puesto;

    @FXML
    private TextField tf_Sexo;

    @FXML
    private TextField tf_SueldoBase;

    @FXML
    private TextField tf_Telefono;

    @FXML
    void AgregarEmpleado_OnAction(ActionEvent event) throws IOException {
        try {
            // Crear un nuevo empleado
            int edad = !tf_Edad.getText().isEmpty() ? Integer.parseInt(tf_Edad.getText()) : 0;
            double sueldo = Double.parseDouble(tf_SueldoBase.getText());

            Empleado empleado = new Empleado(
                    tf_ID.getText(),
                    tf_Nombre.getText(),
                    tf_Apellido.getText(),
                    edad,
                    tf_Sexo.getText(),
                    tf_Correo.getText(),
                    tf_Telefono.getText(),
                    tf_Puesto.getText(),
                    sueldo, new Date()// Fecha de ingreso
            );

            // Agregar empleado al gestor
            gestorEmpleados.addEmpleado(empleado);

            // Asignar cuenta bancaria si no existe
            if (empleado.getCuenta() == null) {
                empleado.AsignarCuentaBancaria();
            }

            // Guardar en la base de datos
            boolean guardadoEmpleados = bd_empleados.Guardar(gestorEmpleados.getEmpleados());
            boolean guardadoCuentas = bd_cuentas.Guardar(cuentasDeBanco);

            if (guardadoEmpleados && guardadoCuentas) {
                Sys.Mensaje("Empleado agregado correctamente.");
            } else {
                Sys.Mensaje("Error al guardar el empleado o las cuentas bancarias.");
            }

            // Recargar tabla
            RecargarEmpleado_OnAction(event);

        } catch (NumberFormatException ex) {
            Sys.Mensaje("Error: Verifica que los campos numéricos sean válidos.");
        }
    }

    @FXML
    void EliminarEmpleado_OnAction(ActionEvent event) throws IOException {
        String idEliminar = tf_IDEliminar.getText();
        if (idEliminar.isEmpty()) {
            Sys.Mensaje("Por favor, ingresa un ID para eliminar.");
            return;
        }

        boolean eliminado = gestorEmpleados.removeEmpleado(idEliminar);
        if (eliminado) {
            Sys.Mensaje("Empleado eliminado correctamente.");
            RecargarEmpleado_OnAction(event);
        } else {
            Sys.Mensaje("Empleado no encontrado.");
        }
    }

    @FXML
    void ExportarBHD_OnAction(ActionEvent event) {

        if (bd_empleados.GuardarBHD(CONST.CUENTA_ORIGEN, gestorEmpleados.getEmpleados())) {
            System.out.println("...");
        }
    }

    @FXML
    void ExportarBanReservas_OnAction(ActionEvent event) {
        if(bd_empleados.GuardarBanReservas(CONST.CUENTA_ORIGEN, gestorEmpleados.getEmpleados())){
            System.out.println("...");
        }
    }

    @FXML
    void ExportarPopular_OnAction(ActionEvent event) {
        if(bd_empleados.GuardarPopular(CONST.CUENTA_ORIGEN, gestorEmpleados.getEmpleados())){
            System.out.println("...");
        }
    }

    @FXML
    void RecargarEmpleado_OnAction(ActionEvent event) {
        empleadosObservableList.setAll(gestorEmpleados.getEmpleados());
    }

    @FXML
    void RecargarNomina_OnAction(ActionEvent event) {
        nominaObservableList.setAll(nomina.getEmpleados());
    }

    @FXML
    void LimpiarEmpleado_OnAction(ActionEvent event) {
        tf_ID.clear();
        tf_Nombre.clear();
        tf_Puesto.clear();
        tf_Sexo.clear();
        tf_SueldoBase.clear();
        tf_Apellido.clear();
        tf_Correo.clear();
        tf_Edad.clear();
        tf_IDEliminar.clear();
        tf_Telefono.clear();
    }

}
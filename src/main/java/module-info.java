module p3.project.projectogestionnomina {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires com.google.gson;

    opens p3.project.projectogestionnomina to javafx.fxml, com.google.gson;
    opens p3.project.projectogestionnomina.Empleados to com.google.gson;
//    opens p3.project.projectogestionnomina to javafx.fxml;

    exports p3.project.projectogestionnomina;
    exports p3.project.projectogestionnomina.Empleados;
}
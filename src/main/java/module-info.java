module com.xvideos.lab6_gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.xvideos.lab6_gui to javafx.fxml;
    exports com.xvideos.lab6_gui;
}
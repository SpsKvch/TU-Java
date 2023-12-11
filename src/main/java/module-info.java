module com.tu.javafxtu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.tu.javafxtu to javafx.fxml;
    exports com.tu.javafxtu;
}
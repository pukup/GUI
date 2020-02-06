module psa.cesa {
    requires javafx.controls;
    requires javafx.fxml;
    requires gson;
    requires java.sql;

    opens psa.cesa.view to javafx.fxml;
    opens psa.cesa.model;
    exports psa.cesa;


}
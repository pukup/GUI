module psa.cesa {
    requires javafx.controls;
    requires javafx.fxml;
    requires gson;

    opens psa.cesa.view to javafx.fxml;
    exports psa.cesa;
}
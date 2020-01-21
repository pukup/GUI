module psa.cesa {
    requires javafx.controls;
    requires javafx.fxml;

    opens psa.cesa to javafx.fxml;
    exports psa.cesa;
}
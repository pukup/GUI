module psa.cesa {
    requires javafx.controls;
    requires javafx.fxml;
    requires gson;

    opens psa.cesa to javafx.fxml;
    exports psa.cesa;
}
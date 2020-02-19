package psa.cesa.view;

import javafx.scene.control.Alert;

public class Message {

    public static void show(String contenido) {
        Alert message = new Alert(Alert.AlertType.ERROR);
        message.setHeaderText(null);
        message.setContentText(contenido);
        message.showAndWait();
    }
}

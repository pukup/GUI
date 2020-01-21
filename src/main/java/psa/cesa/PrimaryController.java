package psa.cesa;

import java.io.IOException;
import javafx.fxml.FXML;
import psa.cesa.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}

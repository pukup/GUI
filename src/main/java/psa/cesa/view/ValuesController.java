package psa.cesa.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import psa.cesa.App;
import psa.cesa.model.Heliostat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ValuesController implements Initializable {

    @FXML
    TextField tfAddress, tfStatusCode, tfEvent, tfError, tfOperation, tfSecurity, tfCom, tfClock, tfAz, tfEl, tfMotAz, tfMotEl, tfStatusReachedAz, tfStatusReachedEl, tfSwingAz, tfSwingEl, tfNotAz, tfNotEl;

    private Heliostat heliostat;

    public ValuesController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("values.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setHeliostat(Heliostat heliostat) {
        this.heliostat = heliostat;
        setValues();
    }

    private void setValues() {
        tfAddress.setText(String.valueOf(heliostat.getId()));
        tfStatusCode.setText(heliostat.state0ToString());
        tfEvent.setText(heliostat.state1ToString());
        tfError.setText("");
        tfOperation.setText(heliostat.eventOperationToString());
        tfSecurity.setText(heliostat.eventSecurityToString());
        tfCom.setText(heliostat.eventComToString());
        tfClock.setText(heliostat.eventCLToString());
        tfAz.setText(String.valueOf(heliostat.getPositionAZ()));
        tfEl.setText(String.valueOf(heliostat.getPositionEL()));
        tfMotAz.setText("");
        tfMotEl.setText("");
        tfStatusReachedAz.setText("");
        tfStatusReachedEl.setText("");
        tfSwingAz.setText("");
        tfSwingEl.setText("");
        tfNotAz.setText("");
        tfNotEl.setText("");
    }
}
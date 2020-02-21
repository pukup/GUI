package psa.cesa.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import psa.cesa.App;
import psa.cesa.model.Heliostat;

import java.io.IOException;

/**
 * It manages the <code>StyleClass</code> of buttons to change them according to <code>Heliostat</code> attributes values.
 */
public class HeliostatButton extends VBox {

    /**
     * @param heliostat is an <code>Heliostat</code> object representation.
     */
    @FXML
    TextField tfAddress, tfStatusCode, tfWarning, tfError, tfOperation, tfSecurity, tfCom, tfClock, tfAz, tfEl, tfMotAz, tfMotEl, tfStatusReachedAz, tfStatusReachedEl, tfSwingAz, tfSwingEl, tfNotAz, tfNotEl;

    @FXML
    private Button button;

    private int comLineId;

    private Heliostat heliostat;

    private Scene valuesScene;

    public HeliostatButton() {
        try {
            loadButton();
            loadValues();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void loadButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("heliostatButton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    private void loadValues() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("values.fxml"));
        fxmlLoader.setController(this);
        valuesScene = new Scene(fxmlLoader.load());
    }

    public void setHeliostat(int comLineId, Heliostat heliostat) {
        this.comLineId = comLineId;
        this.heliostat = heliostat;
        setValues();
        showState0();
        showState1();
        showEventOperation();
        showEventSecurity();
        showEventCom();
    }

    @FXML
    protected void openValues(ActionEvent event) {
        Stage stage = new Stage();
        stage.setScene(valuesScene);
        stage.show();
    }

    public void setValues() {
        if (tfAddress != null) {
            tfAddress.setText(String.format("%s modbus:%d-%d", this.getId(), comLineId, heliostat.getId()));
            tfStatusCode.setText(heliostat.state0ToString());
            tfWarning.setText(heliostat.state1ToString());
            tfError.setText("");
            tfOperation.setText(heliostat.eventOperationToString());
            tfSecurity.setText(heliostat.eventSecurityToString());
            tfCom.setText(heliostat.eventComToString());
            tfClock.setText(heliostat.eventCLToString());
            tfAz.setText(String.valueOf(heliostat.getPositionAZ()));
            tfEl.setText(String.valueOf(heliostat.getPositionEL()));
            tfMotAz.setText(heliostat.diagnosisAz0ToString());
            tfMotEl.setText(heliostat.diagnosisEl0ToString());
            tfStatusReachedAz.setText(heliostat.diagnosisAz1ToString());
            tfStatusReachedEl.setText(heliostat.diagnosisEl1ToString());
            tfSwingAz.setText(heliostat.diagnosisAz2ToString());
            tfSwingEl.setText(heliostat.diagnosisEl2ToString());
            tfNotAz.setText(heliostat.diagnosisAz3ToString());
            tfNotEl.setText(heliostat.diagnosisEl3ToString());
        }
    }

    /**
     * It changes the button GUI skin according to its first nibble state.
     */
    public void showState0() {
        int nibble0 = 0x0f & heliostat.getState();
        switch (nibble0) {
            case 0x0:
                //                                state0.append("Operación local");
                button.getStyleClass().add("blue-pin");
                break;
            case 0x1:
                //                Consiga fija
                button.getStyleClass().add("blue-pin");
                break;
            case 0x2:
                //                Busqueda de ceros
                button.getStyleClass().add("blue-pin");
                break;
            case 0x3:
                //                Fuera de servicio
                button.getStyleClass().add("grey-pin");
                break;
            case 0x4:
                //                Posición de defensa
                button.getStyleClass().add("blue-pin");
                break;
            case 0x5:
                //                Abatimiento normal
                button.getStyleClass().add("blue-pin");
                break;
            case 0x6:
                //                Blanco tierra
                button.getStyleClass().add("blue-pin");
                break;
            case 0x7:
                //                Blanco pasillo 1
                button.getStyleClass().add("blue-pin");
                break;
            case 0x8:
                //                Blanco pasillo 2
                button.getStyleClass().add("blue-pin");
                break;
            case 0x9:
                //                Blanco pasillo 3
                button.getStyleClass().add("blue-pin");
                break;
            case 0xa:
                //                Blanco pasillo 4
                button.getStyleClass().add("blue-pin");
                break;
            case 0xb:
                //                Seguimiento desfasado
                button.getStyleClass().add("orange-pin");
                break;
            case 0xc:
                //                Blanco de emergencia
                button.getStyleClass().add("blue-pin");
                break;
            case 0xd:
                //                Seguimiento normal a caldera
                button.getStyleClass().add("red-pin");
                break;
            case 0xe:
                //                Foco
                button.getStyleClass().add("red-pin");
                break;
            case 0xf:
                //                Seguimiento normal al sol
                button.getStyleClass().add("red-pin");
                break;
        }
    }

    /**
     * It changes the button GUI skin according to its first nibble state.
     */
    public void showState1() {
        int nibble1 = 0xf0 & heliostat.getState();
        if ((nibble1 & 0x80) == 0x80) {
            //            Aviso error
            button.getStyleClass().add("orange-pin");
        }
        if ((nibble1 & 0x40) == 0x40) {
            //            Aviso evento
            button.getStyleClass().add("orange-pin");
        }
        if ((nibble1 & 0x20) == 0x20) {
            //            Consigna alcanzada EL
            button.getStyleClass().add("orange-pin");
        }
        if ((nibble1 & 0x10) == 0x10) {
            //            Consigna alcanzada AZ
            button.getStyleClass().add("orange-pin");
        }
    }

    /**
     * Converts the two least significant bits from event byte to a string message.
     *
     * @return operation event message.
     */
    public void showEventOperation() {
        int coupleBits0 = 0x3 & heliostat.getEvent();
        switch (coupleBits0) {
            case 0x1:
                //                Fuera de servicio
                button.getStyleClass().add("grey-pin");
                break;
            case 0x2:
                //                Heliostato teleconfigurado
                button.getStyleClass().add("grey-pin");
                break;
        }
    }

    public void showEventSecurity() {
        int coupleBits1 = 0xc & heliostat.getEvent();
        switch (coupleBits1) {
            case 0x4:
                //                  Código de cliente erróneo
                button.getStyleClass().add("grey-pin");
                break;
        }
    }

    public void showEventCom() {
        int coupleBits2 = 0x30 & heliostat.getEvent();
        switch (coupleBits2) {
            case 0x10:
                //                Fallo de comunicaciones
                button.getStyleClass().add("black-pin");
                break;
            case 0x20:
                //                No acpeta el comando
                button.getStyleClass().add("red-pin");
                break;
        }
    }
}

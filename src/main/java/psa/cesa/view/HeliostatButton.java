package psa.cesa.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
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
    private int ComLineId;
    private Heliostat heliostat;
    private ValuesController valuesController;

    public HeliostatButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("heliostatButton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setHeliostat(Heliostat heliostat) {
        this.heliostat = heliostat;
        if (valuesController != null && valuesController.tfAddress != null)
            valuesController.setHeliostat(heliostat);
        setStates();
    }

    private void setStates() {
        showState0();
        showState1();
        showEventOperation();
        showEventSecurity();
        showEventCom();
    }

    @FXML
    protected void openValues() throws IOException {
        valuesController = new ValuesController();
    }

    /**
     * It changes the button GUI skin according to its first nibble state.
     */
    public void showState0() {
        int nibble0 = 0x0f & heliostat.getState();
        switch (nibble0) {
            case 0x0:
                //                                state0.append("Operación local");
                //                                this.setStyle("button-pin-blue");
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0x1:
                //                Consiga fija
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0x2:
                //                Busqueda de ceros
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0x3:
                //                Fuera de servicio
                this.getStyleClass().add("button-pin-grey");
                break;
            case 0x4:
                //                Posición de defensa
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0x5:
                //                Abatimiento normal
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0x6:
                //                Blanco tierra
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0x7:
                //                Blanco pasillo 1
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0x8:
                //                Blanco pasillo 2
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0x9:
                //                Blanco pasillo 3
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0xa:
                //                Blanco pasillo 4
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0xb:
                //                Seguimiento desfasado
                this.getStyleClass().add("button-pin-orange");
                break;
            case 0xc:
                //                Blanco de emergencia
                this.getStyleClass().add("button-pin-blue");
                break;
            case 0xd:
                //                Seguimiento normal a caldera
                this.getStyleClass().add("button-pin-red");
                break;
            case 0xe:
                //                Foco
                this.getStyleClass().add("button-pin-red");
                break;
            case 0xf:
                //                Seguimiento normal al sol
                this.getStyleClass().add("button-pin-red");
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
            this.getStyleClass().add("button-pin-orange");
        }
        if ((nibble1 & 0x40) == 0x40) {
            //            Aviso evento
            this.getStyleClass().add("button-pin-orange");
        }
        if ((nibble1 & 0x20) == 0x20) {
            //            Consigna alcanzada EL
            this.getStyleClass().add("button-pin-orange");
        }
        if ((nibble1 & 0x10) == 0x10) {
            //            Consigna alcanzada AZ
            this.getStyleClass().add("button-pin-orange");
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
                this.getStyleClass().add("grey-pin");
                break;
            case 0x2:
                //                Heliostato teleconfigurado
                this.getStyleClass().add("grey-pin");
                break;
        }
    }

    public void showEventSecurity() {
        int coupleBits1 = 0xc & heliostat.getEvent();
        switch (coupleBits1) {
            case 0x4:
                //                  Código de cliente erróneo
                this.getStyleClass().add("grey-pin");
                break;
        }
    }

    public void showEventCom() {
        int coupleBits2 = 0x30 & heliostat.getEvent();
        switch (coupleBits2) {
            case 0x10:
                //                Fallo de comunicaciones
                this.getStyleClass().add("red-pin");
                break;
            case 0x20:
                //                No acpeta el comando
                this.getStyleClass().add("red-pin");
                break;
        }
    }
}

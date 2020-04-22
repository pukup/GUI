package psa.cesa.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import psa.cesa.model.Heliostat;

public class Groups {

    @FXML
    private ListView listView;
    @FXML
    ImageView iEl1, iAz;
    @FXML
    ComboBox<Integer> cbFocus;
    @FXML
    TextArea textArea;

    @FXML
    private void dejection(ActionEvent event) {
        textArea.appendText(command("a") + "\n");
    }

    @FXML
    private void aisle(ActionEvent event) {
        textArea.appendText(command("b") + "\n");
    }

    @FXML
    private void kilter(ActionEvent event) {
        textArea.appendText(command("d") + "\n");
    }

    @FXML
    private void boiler(ActionEvent event) {
        textArea.appendText(command("e") + "\n");
    }

    @FXML
    private void immobilize(ActionEvent event) {
        textArea.appendText(command("i") + "\n");
    }

    @FXML
    private void outService(ActionEvent event) {
        textArea.appendText(command("l") + "\n");
    }

    @FXML
    private void tracking(ActionEvent event) {
        textArea.appendText(command("n") + "\n");
    }

    @FXML
    private void emergency(ActionEvent event) {
        textArea.appendText(command("q") + "\n");
    }

    @FXML
    private void kilterAisle(ActionEvent event) {
        textArea.appendText(command("s") + "\n");
    }

    private String command(String b) {
        return "";
    }

    @FXML
    private void setFocus() {
    }

    @FXML
    private void newFocus() {
    }

    @FXML
    private void setAzEl() {
    }

    @FXML
    private void getOffset() {
    }

    @FXML
    private void setOffset() {

    }

    @FXML
    private void getHour() {
    }

    @FXML
    private void setHour() {
    }

}

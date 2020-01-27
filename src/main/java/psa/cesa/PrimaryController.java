package psa.cesa;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import psa.cesa.App;

public class PrimaryController implements Initializable {

    @FXML
    private VBox rows_vbox;

    @FXML
    private Button button;

    @FXML
    private Slider zoom_slider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        zoom_slider.valueProperty().addListener((o, oldVal, newVal) -> zoom());
    }

    @FXML
    void zoomIn(ActionEvent event) {
        double sliderVal = zoom_slider.getValue();
        zoom_slider.setValue(sliderVal += 1);
    }

    @FXML
    void zoomOut(ActionEvent event) {
        double sliderVal = zoom_slider.getValue();
        zoom_slider.setValue(sliderVal -= 1);
    }

    @FXML
    private void zoom() {
        rows_vbox.styleProperty().bind(Bindings.format("-fx-font-size: %.2fpt;", zoom_slider.getValue()));
    }

    @FXML
    private void openValues() throws IOException {
        Scene scene = new Scene(loadFXML("secondary"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        button.getStyleClass().add("button2");
//        App.setRoot("secondary");
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}

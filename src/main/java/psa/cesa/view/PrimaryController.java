package psa.cesa.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import psa.cesa.App;
import psa.cesa.controller.HeliostatController;
import psa.cesa.model.Heliostat;
import psa.cesa.model.HeliostatDAO;
import psa.cesa.model.Row;
import psa.cesa.model.RowDAO;

/**
 *
 */
public class PrimaryController implements Initializable {

    /**
     *
     */
    private HeliostatController heliostatController = new HeliostatController();
    private Heliostat[] heliostats;

    @FXML
    private VBox rows_vbox;

    @FXML
    private Slider zoom_slider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addRows();
        zoom_slider.valueProperty().addListener((o, oldVal, newVal) -> zoom());
    }

    private void addRows() {
//        Row[] rows = RowDAO.pollField();
        HBox hBox = new HBox();
        hBox.setSpacing(30.0);
        hBox.setAlignment(Pos.CENTER);
        Region region = new Region();
        hBox.setHgrow(region, Priority.ALWAYS);
        hBox.getChildren().add(region);
        Label label = new Label("16");
        label.setFont(new Font(18));
        label.setTextFill(Color.WHITE);
        hBox.getChildren().add(label);
        rows_vbox.getChildren().add(hBox);
    }

    @FXML
    private void zoom() {
        rows_vbox.styleProperty().bind(Bindings.format("-fx-font-size: %.2fpt;", zoom_slider.getValue()));
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
    private void openValues(ActionEvent event) throws IOException {
        System.out.println(event.getSource().toString());
        Scene scene = new Scene(loadFXML("secondary"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}

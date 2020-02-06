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
import psa.cesa.controller.RowController;
import psa.cesa.model.ComLine;
import psa.cesa.model.Heliostat;

/**
 *
 */
public class PrimaryController implements Initializable {

    @FXML
    private VBox rows_vbox;

    @FXML
    private Slider zoom_slider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //        addRows();
        zoom_slider.valueProperty().addListener((o, oldVal, newVal) -> zoom());
    }

    /**
     * It sets the GUI elements to represent the <code>Row</code> objects which are obtained from the server
     */
    private void addRows() {
        ComLine[] Comlines = RowController.loadField();
        for (ComLine comLine : Comlines) {
            rows_vbox.getChildren().add(createGUIHbox(comLine));
        }
    }

    private HBox createGUIHbox(ComLine comLine) {
        HBox hBox = new HBox();
        hBox.setSpacing(30.0);
        hBox.setAlignment(Pos.CENTER);
        createRegion(hBox);
        createLabel(comLine, hBox);
        createButtons(comLine, hBox);
        createLabel(comLine, hBox);
        createRegion(hBox);
        return hBox;
    }

    private void createRegion(HBox hBox) {
        Region region = new Region();
        hBox.setHgrow(region, Priority.ALWAYS);
        hBox.getChildren().add(region);
    }

    private void createLabel(ComLine comLine, HBox hBox) {
        Label label = new Label(String.valueOf(comLine.getId()));
        label.setFont(new Font(18));
        label.setTextFill(Color.WHITE);
        hBox.getChildren().add(label);
    }

    private void createButtons(ComLine comLine, HBox hBox) {
        for (Heliostat heliostat : comLine.getHeliostats().values()) {
            Button button = new Button();
            hBox.getChildren().add(button);
        }
    }

    @FXML
    private void emergency() {
        // The ones in focus must go to kilter focus throw aisle.
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
    public void openValues(ActionEvent event) throws IOException {
        Scene scene = new Scene(loadFXML("values"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openGrouping(ActionEvent event) throws IOException {
        Scene scene = new Scene(loadFXML("groups"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}

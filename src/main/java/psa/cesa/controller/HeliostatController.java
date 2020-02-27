package psa.cesa.controller;

import javafx.application.Platform;
import psa.cesa.model.dao.HeliostatDAO;
import psa.cesa.view.Message;

import java.io.IOException;

public class HeliostatController {

    private HeliostatDAO heliostatDAO = new HeliostatDAO();

    public String command(int comLineId, int heliostatId, String command) {
        try {
            return heliostatDAO.command("http://localhost:8080/command?comLineId=" + comLineId + "&heliostatId=" + heliostatId + "&command=" + command);
        } catch (IOException e) {
            Platform.runLater(() -> {
                Message.show(e.getMessage());
            });
            return "No response.";
        }
    }
}

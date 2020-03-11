package psa.cesa.controller;

import javafx.application.Platform;
import psa.cesa.model.ComLine;
import psa.cesa.model.dao.ComLineDAO;
import psa.cesa.view.Message;

import java.io.IOException;

public class ComLineController {

    private static ComLineDAO comLineDAO = new ComLineDAO();

    public static ComLine getAPICache(int comLineId) {
        try {
            return comLineDAO.getAPICache("http://localhost:8080/getCache?comLineId=" + comLineId);
        } catch (IOException e) {
            Platform.runLater(() -> {
                Message.showExit(e.getMessage());
            });
            return null;
        }
    }
}

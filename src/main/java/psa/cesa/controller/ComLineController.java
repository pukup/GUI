package psa.cesa.controller;

import psa.cesa.model.ComLine;
import psa.cesa.model.dao.ComLineDAO;

public class ComLineController {

    private static ComLineDAO comLineDAO = new ComLineDAO();

    public static ComLine[] getComLines() {
        return comLineDAO.load("http://localhost:8080/getComLines/");
    }

    public ComLine[] pollField() {
        return comLineDAO.load("http://localhost:8080/pollField/");
    }
}

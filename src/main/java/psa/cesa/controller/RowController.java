package psa.cesa.controller;

import psa.cesa.model.ComLine;
import psa.cesa.model.dao.ComLineDAO;

public class RowController {

    private static ComLineDAO comLineDAO = new ComLineDAO();

    public static ComLine[] loadField() {
        return comLineDAO.load("http://localhost:8080/loadField/");
    }

    public static ComLine[] pollField() {
        return comLineDAO.load("http://localhost:8080/pollField/");
    }
}

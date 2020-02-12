package psa.cesa.controller;

import psa.cesa.model.Heliostat;
import psa.cesa.model.dao.HeliostatDAO;

public class HeliostatController {

    private HeliostatDAO heliostatDAO = new HeliostatDAO();

    public Heliostat poll(int rowId, int heliostatAddress) {
        return heliostatDAO.poll(rowId, heliostatAddress);
    }

    //comand
}

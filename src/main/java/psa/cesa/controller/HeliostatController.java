package psa.cesa.controller;

import psa.cesa.model.dao.HeliostatDAO;

public class HeliostatController {

    private HeliostatDAO heliostatDAO = new HeliostatDAO();

    public void command(int rowId, int heliostatAddress, String command) {
        heliostatDAO.command(rowId, heliostatAddress, command);
    }

}

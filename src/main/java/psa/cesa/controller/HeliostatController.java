package psa.cesa.controller;

import psa.cesa.model.Heliostat;
import psa.cesa.model.dao.HeliostatDAO;

public class HeliostatController {
    //Lanzar interface -> Interface llama control -> control actualiza interface

    private static HeliostatDAO heliostatDAO = new HeliostatDAO();

    public static Heliostat poll(int rowId, int heliostatAddress) {
        return heliostatDAO.poll(rowId, heliostatAddress);
    }


}

package psa.cesa.controller;

import psa.cesa.model.ComLine;
import psa.cesa.model.dao.ComLineDAO;

public class ComLineController {

    private static ComLineDAO comLineDAO = new ComLineDAO();

    public static ComLine getCache(int comLineId) {
        return comLineDAO.getCache("http://localhost:8080/getCache?comLineId=" + comLineId);
    }
}

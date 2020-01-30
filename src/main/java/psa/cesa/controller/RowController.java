package psa.cesa.controller;

import psa.cesa.model.Row;
import psa.cesa.model.RowDAO;

public class RowController {

    private RowDAO rowDAO = new RowDAO();

    public Row[] pollField() {
        return rowDAO.pollField();
    }
}

package psa.cesa.model.dao;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class HeliostatDAO {

    /**
     * @param rowId
     * @param heliostatAddress
     * @param command
     */
    public void command(int rowId, int heliostatAddress, String command) {
        try {
            URLConnection urlConnection = new URL("http://localhost:8080/command/" + rowId + "/" + heliostatAddress + "/" + command).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package psa.cesa.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HeliostatDAO {
    /**
     * @param rowId
     * @param heliostatAddress
     * @return
     */
    public Heliostat poll(int rowId, int heliostatAddress) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URLConnection urlConnection = new URL("http://localhost:8080/poll/" + rowId + "/" + heliostatAddress).openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            char[] chars = new char[1024];
            int readedChar;
            while ((readedChar = inputStreamReader.read(chars, 0, chars.length)) > 0) {
                stringBuilder.append(chars, 0, readedChar);
            }
            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = stringBuilder.toString();
        Gson gson = new Gson();
        return gson.fromJson(s, Heliostat.class);
    }

    /**
     * @param rowId
     * @param heliostatAddress
     * @param command
     * @return
     */
    public String command(int rowId, int heliostatAddress, String command) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URLConnection urlConnection = new URL("http://localhost:8080/command/" + rowId + "/" + heliostatAddress + "/" + command).openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            char[] chars = new char[1024];
            int readedChar;
            while ((readedChar = inputStreamReader.read(chars, 0, chars.length)) > 0) {
                stringBuilder.append(chars, 0, readedChar);
            }
            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "s";
    }

}

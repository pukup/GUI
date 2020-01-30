package psa.cesa.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class RowDAO {
    /**
     * It connects to the server URL and gets a <code>Row</code> array
     *
     * @return
     */
    public Row[] pollField() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URLConnection urlConnection = new URL("http://localhost:8080/pollField/").openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            char[] chars = new char[1024];
            int readedChar;
            while ((readedChar = inputStreamReader.read(chars, 0, chars.length)) > 0) {
                stringBuilder.append(chars, 0, readedChar);
            }
            inputStreamReader.close();
            String s = stringBuilder.toString();
            Gson gson = new Gson();
            return gson.fromJson(s, Row[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

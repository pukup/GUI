package psa.cesa.model.dao;

import com.google.gson.Gson;
import psa.cesa.model.ComLine;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


/**
 * It connects to the server URL and gets a <code>Row</code> array
 *
 * @return
 */
public class ComLineDAO {

    /**
     * @param url
     * @return
     */
    public ComLine getAPICache(String url) throws IOException {
        String s = getAPIString(url);
        Gson gson = new Gson();
        return gson.fromJson(s, ComLine.class);
    }

    private String getAPIString(String url) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        URLConnection urlConnection = new URL(url).openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        char[] chars = new char[1024];
        int readedChar;
        while ((readedChar = inputStreamReader.read(chars, 0, chars.length)) > 0) {
            stringBuilder.append(chars, 0, readedChar);
        }
        inputStreamReader.close();
        return stringBuilder.toString();
    }
}
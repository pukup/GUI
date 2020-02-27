package psa.cesa.model.dao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HeliostatDAO {

    public String command(String url) throws IOException {
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

    //    public String command(String url) throws IOException {
    //        BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openConnection().getInputStream()));
    //        String inputLine;
    //        StringBuffer stringBuffer = new StringBuffer();
    //        while ((inputLine = in.readLine()) != null) {
    //            stringBuffer.append(inputLine);
    //        }
    //        in.close();
    //        return inputLine;
    //    }
}

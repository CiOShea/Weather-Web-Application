package utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherAPIUtils {

    public static InputStream requestByLocation (String location) throws IOException {
        URL baseUrl = new URL("https://community-open-weather-map.p.rapidapi.com/weather?q="+ location + "&units=metric");
        HttpURLConnection connection = (HttpURLConnection) baseUrl.openConnection();
        connection.setRequestProperty("accept" , "application/json");
        connection.setRequestProperty("x-rapidapi-key" , "6df87e620amsh8f376a6ff847e8dp152ebbjsn08d611c3d812");
        connection.setRequestProperty("x-rapidapi-host" , "community-open-weather-map.p.rapidapi.com");
        InputStream responseStream = connection.getInputStream();

        return responseStream;
    }
}

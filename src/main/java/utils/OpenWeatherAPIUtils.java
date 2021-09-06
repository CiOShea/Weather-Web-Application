package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import weather.Root;

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

    public static String getDetails(InputStream response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Root rootObject = mapper.readValue(response , Root.class);

        System.out.println("LOCATION");
        System.out.println("latitude: " + rootObject.getCoord().getLat());
        System.out.println("longitude " + rootObject.getCoord().getLon());
        System.out.println();
        System.out.println("TEMPERATURE");
        System.out.println("Current Temp: " + rootObject.getMain().getTemp() + " deg C");
        System.out.println("Max Temp: " + rootObject.getMain().getMaxTemp() + " deg C");
        System.out.println("Min Temp: " + rootObject.getMain().getMinTemp() + " deg C");
        System.out.println("Feels Like: " + rootObject.getMain().getFeelsLike() + " deg C");
        System.out.println((rootObject.getWeather().get(0).getMain()));

        return "location" + rootObject.getName() + "<br> latitude " +rootObject.getCoord().getLat() +
                "<br> Current Temp: " + rootObject.getMain().getTemp() + " deg C"
                + "<br> Current conditions: " + rootObject.getWeather().get(0).getMain();

    }
}

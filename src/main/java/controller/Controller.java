package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.OpenWeatherAPIUtils;
import weather.Main;
import weather.Root;
import weather.Weather;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.println("Type your location here");
        String location = in.nextLine();

        InputStream response = OpenWeatherAPIUtils.requestByLocation(location);
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

    }
}

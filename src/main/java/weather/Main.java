package weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;
    @JsonProperty ("temp_min")
    private double minTemp;
    @JsonProperty("temp_max")
    private double maxTemp;
    private int pressure;
    private int humidity;

    public Main(double temp, double feelsLike, double minTemp, double maxTemp, int pressure, int humidity) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Main () {

    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}

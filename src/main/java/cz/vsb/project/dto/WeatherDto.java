package cz.vsb.project.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

public class WeatherDto {
    private String location;
    private ZonedDateTime timestamp;
    private double temp_celsius;
    private double windSpeed_mps;
    private int rel_humadity;
    private String wind_direction;
    private String weather_description;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        //formatter.parse(timestamp); //Sun Jan 07 09:47:00 CET 2024
        this.timestamp = ZonedDateTime.ofInstant(formatter.parse(timestamp).toInstant(), ZoneId.systemDefault());
    }

    public double getTemp_celsius() {
        return temp_celsius;
    }

    public void setTemp_celsius(double temp_celsius) {
        this.temp_celsius = temp_celsius;
    }

    public double getWindSpeed_mps() {
        return windSpeed_mps;
    }

    public void setWindSpeed_mps(double windSpeed_mps) {

        this.windSpeed_mps = (double) Math.round(windSpeed_mps/3.6 *100)/100;
    }

    public int getRel_humadity() {
        return rel_humadity;
    }

    public void setRel_humadity(int rel_humadity) {
        this.rel_humadity = rel_humadity;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getWeather_description() {
        return weather_description;
    }

    public void setWeather_description(String weather_description) {
        this.weather_description = weather_description;
    }
}

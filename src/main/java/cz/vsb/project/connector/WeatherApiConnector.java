package cz.vsb.project.connector;

import cz.vsb.project.City;
import cz.vsb.project.dto.WeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherApiConnector {
    //https://api.weatherapi.com/v1/current.json?key=b7f8526580da436b83a144144231312&q=London&aqi=no

    private static String baseUrl = "https://api.weatherapi.com/v1/";
    private static String urlParameters = "current.json?key=";
    private static String APIKey = "b7f8526580da436b83a144144231312";
    private static String url = baseUrl + urlParameters + APIKey + "&q=";

    public WeatherApiDto getWeatherForCity (City city) throws URISyntaxException {
        RestTemplate template = new RestTemplate();
        URI uri = new URI(url + city.toString());
        ResponseEntity<WeatherApiDto> responseEntity = template.getForEntity(uri, WeatherApiDto.class);
        return responseEntity.getBody();
    }

}

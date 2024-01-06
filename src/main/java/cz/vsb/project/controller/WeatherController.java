package cz.vsb.project.controller;

import cz.vsb.project.City;
import cz.vsb.project.dto.WeatherDto;
import cz.vsb.project.service.WeatherService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class WeatherController {
    private final WeatherService weatherService;
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/weather")
    public Collection<WeatherDto> getWeather() throws URISyntaxException {
        List<WeatherDto> weatherDtoList = new ArrayList<>();
        for(City city:City.values()){
            weatherDtoList.add(weatherService.getWeatherForCity(city));
        }
        return weatherDtoList;
    }

    @RequestMapping("/weather/{city}")
    public WeatherDto getWeatherForCity(@PathVariable ("city") String city) throws URISyntaxException {
        City cityEnum = City.valueOf(city.toUpperCase());
        return weatherService.getWeatherForCity(cityEnum);
    }

}

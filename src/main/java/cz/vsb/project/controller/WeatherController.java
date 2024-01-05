package cz.vsb.project.controller;

import cz.vsb.project.City;
import cz.vsb.project.dto.WeatherDto;
import cz.vsb.project.service.WeatherService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class WeatherController {
    @RequestMapping("/weather/{city}")
    public WeatherDto getWeatherForCity(@PathVariable ("city") String city) throws URISyntaxException {
        City cityEnum = City.valueOf(city.toUpperCase());
        WeatherService weatherService = new WeatherService();
        return weatherService.getWeatherForCity(cityEnum);
    }

}

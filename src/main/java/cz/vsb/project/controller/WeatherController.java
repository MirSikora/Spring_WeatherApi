package cz.vsb.project.controller;

import cz.vsb.project.City;
import cz.vsb.project.dto.WeatherDto;
import cz.vsb.project.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("")
    public String getWeather(Model model) throws Exception {
        List<WeatherDto> weatherDtoList = new ArrayList<>();
        for(City city:City.values()){
            weatherDtoList.add(weatherService.getWeatherForCity(city));
        }
        model.addAttribute("weatherInCities",weatherDtoList);
        return "allcities";

    }

    @RequestMapping("/{city}")
    public String getWeatherForCity(@PathVariable ("city") String city, Model model) throws Exception {
        City cityEnum = City.valueOf(city.toUpperCase());
        WeatherDto weatherDto = weatherService.getWeatherForCity(cityEnum);
        model.addAttribute("About0neCity", weatherDto);
        return "onecity";
    }

}

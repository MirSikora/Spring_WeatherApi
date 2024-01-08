package cz.vsb.project.controller;

import cz.vsb.project.City;
import cz.vsb.project.dto.WeatherDto;
import cz.vsb.project.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    WeatherService weatherService;

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

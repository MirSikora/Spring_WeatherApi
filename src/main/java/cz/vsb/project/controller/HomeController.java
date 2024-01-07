package cz.vsb.project.controller;

import cz.vsb.project.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URISyntaxException;
import java.text.ParseException;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("AllCities",City.values());
        return "index";
    }
}

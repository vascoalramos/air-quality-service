package tqs.homework.airquality.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tqs.homework.airquality.model.City;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 10:50
 */

@Controller
@RequestMapping({"/", "/index", "/by-city"})
public class IndexController {

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("city", new City());
        return "index";
    }

    @PostMapping
    public String showMetrics(City city, Model model) {
        model.addAttribute("city_id", city.getText());
        return "air-metrics";
    }
}

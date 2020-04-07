package tqs.homework.airquality.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tqs.homework.airquality.model.Keys;

/**
 * @author Vasco Ramos
 * @date 07/04/20
 * @time 17:17
 */

@Controller
@RequestMapping({"/by-day"})
public class AirMetricsByDayController {

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("keys", new Keys());
        return "by-day";
    }

    @PostMapping
    public String showMetrics(Keys keys, Model model) {
        model.addAttribute("city_id", keys.getCity().getText());
        model.addAttribute("day", keys.getDay());
        return "air-metrics-by-day";
    }
}

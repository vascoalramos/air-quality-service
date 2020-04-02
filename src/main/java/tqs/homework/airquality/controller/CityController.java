package tqs.homework.airquality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tqs.homework.airquality.model.City;
import tqs.homework.airquality.service.CityService;

import java.util.List;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:34
 */

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> getAllCities(@RequestParam(value = "q", required = false) String query) {
        if (query == null) {
            return cityService.getAllCities();
        }
        return cityService.getCitiesContains(query);
    }

}

package tqs.homework.airquality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tqs.homework.airquality.model.AirMetrics;
import tqs.homework.airquality.service.AirQualityService;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:34
 */

@RestController
@RequestMapping("/api")
public class AirQualityController {

    @Autowired
    private AirQualityService weatherBitService;

    @GetMapping("/air-metrics")
    public AirMetrics getAirMetrics(@RequestParam(value = "city_id", required = false) Long city_id) {
        return weatherBitService.getCurrentAirMetrics(city_id);
    }
}

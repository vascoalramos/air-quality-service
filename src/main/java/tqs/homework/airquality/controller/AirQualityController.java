package tqs.homework.airquality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tqs.homework.airquality.model.AirMetrics;
import tqs.homework.airquality.service.WeatherBitService;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:34
 */

@RestController
@RequestMapping("/api")
public class AirQualityController {

    @Autowired
    private WeatherBitService weatherBitService;

    @GetMapping("/air-metrics")
    public AirMetrics getAirMetrics() {
        return weatherBitService.getCurrentAirMetrics();
    }
}

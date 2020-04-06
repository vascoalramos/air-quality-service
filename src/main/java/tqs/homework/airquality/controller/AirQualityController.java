package tqs.homework.airquality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
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
    public AirMetrics getAirMetrics(@RequestParam(value = "city_id", required = false) Long cityId,
                                    @RequestParam(value = "day", required = false) String day) {

        if (cityId != null && day != null && !day.isEmpty()) {
            if (day.split("-").length != 3) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "The value specified under the day parameter: " + day + " - is invalid");
            }
            return weatherBitService.getAirMetricsByDay(cityId, day);
        } else if (cityId != null) {
            return weatherBitService.getCurrentAirMetrics(cityId);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing request parameters");
        }
    }
}

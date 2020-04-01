package tqs.homework.airquality.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:34
 */

@RestController
public class AirQualityController {


    @GetMapping("/air-metrics")
    public ResponseEntity<String> getAllCities() {
        return new ResponseEntity<>("Metrics", HttpStatus.OK);
    }
}

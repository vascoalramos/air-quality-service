package tqs.homework.airquality.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tqs.homework.airquality.model.AirMetrics;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 13:58
 */

@Service
public class WeatherBitService {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    private static String BASE_URL = "https://api.weatherbit.io/v2.0/current/airquality";
    private static String TOKEN = "0fc2afb40f3d46859bbb4b64f7ea7eb3";
    private String city = "Viseu,PT";

    public AirMetrics getCurrentAirMetrics() {
        String url = BASE_URL + "?city=" + city + "&key=" + TOKEN;
        return this.restTemplate.getForObject(url, AirMetrics.class);
    }
}

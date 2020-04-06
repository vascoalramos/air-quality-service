package tqs.homework.airquality.repository;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tqs.homework.airquality.model.AirMetrics;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vasco Ramos
 * @date 06/04/20
 * @time 10:47
 */

@Repository
public class WeatherBitRepository {
    private static final Logger logger = Logger.getLogger(WeatherBitRepository.class.getName());
    private static final String BASE_URL = "https://api.weatherbit.io/v2.0/current/airquality";
    private static final String TOKEN = "0fc2afb40f3d46859bbb4b64f7ea7eb3";

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    public AirMetrics getMetrics(long cityId) {
        AirMetrics result = null;
        try {
            String url = BASE_URL + "?city_id=" + cityId + "&key=" + TOKEN;
            result = this.restTemplate.getForObject(url, AirMetrics.class);
        }
        catch (Exception ex) {
            logger.log(Level.WARNING, ex.toString());
        }

        return result;
    }
}

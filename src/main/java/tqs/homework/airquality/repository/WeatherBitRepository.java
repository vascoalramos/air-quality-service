package tqs.homework.airquality.repository;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tqs.homework.airquality.cache.Cache;
import tqs.homework.airquality.model.AirMetrics;

/**
 * @author Vasco Ramos
 * @date 06/04/20
 * @time 10:47
 */

@Repository
public class WeatherBitRepository {
    private static final String BASE_URL = "https://api.weatherbit.io/v2.0/current/airquality";
    private static final String TOKEN = "0fc2afb40f3d46859bbb4b64f7ea7eb3";

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    private final Cache cache = new Cache(5*60L);

    public AirMetrics getMetrics(long cityId) {
        String cityIdString = String.valueOf(cityId);
        AirMetrics result = cache.getRequest(cityIdString);

        if (result == null) {
            try {
                String url = BASE_URL + "?city_id=" + cityId + "&key=" + TOKEN;
                result = this.restTemplate.getForObject(url, AirMetrics.class);
                cache.storeRequest(cityIdString, result);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        return result;
    }
}

package tqs.homework.airquality.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tqs.homework.airquality.model.AirMetrics;
import tqs.homework.airquality.repository.WeatherBitRepository;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 13:58
 */

@Service
public class AirQualityService {

    @Autowired
    private WeatherBitRepository externalApi;

    public AirMetrics getCurrentAirMetrics(long cityId) {
        return this.externalApi.getMetrics(cityId);
    }
}

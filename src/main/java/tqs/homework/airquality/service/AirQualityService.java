package tqs.homework.airquality.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
        AirMetrics result = this.externalApi.getMetrics(cityId);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Request not valid. Please check api token and city_id");
        } else {
            return result;
        }
    }
}

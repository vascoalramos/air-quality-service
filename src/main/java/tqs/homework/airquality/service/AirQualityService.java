package tqs.homework.airquality.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tqs.homework.airquality.cache.Cache;
import tqs.homework.airquality.model.AirMetrics;
import tqs.homework.airquality.repository.BreezoMeeterRepository;
import tqs.homework.airquality.repository.WeatherBitRepository;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 13:58
 */

@Service
public class AirQualityService {

    private final Cache cache = new Cache(5 * 60L);

    @Autowired
    private WeatherBitRepository externalApi1;

    @Autowired
    private BreezoMeeterRepository externalApi2;

    public AirMetrics getCurrentAirMetrics(long cityId) {
        String cityIdString = String.valueOf(cityId);
        AirMetrics result = cache.getRequest(cityIdString);

        if (result == null) {
            result = this.externalApi1.getMetrics(cityId);

            if (result == null) {
                result = this.externalApi2.getCurrentMetricsById(cityId);

                if (result == null) {
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                            "Request not valid.  Please check api token and city_id");
                }
            }
        }

        cache.storeRequest(cityIdString, result);
        return result;
    }

    public AirMetrics getAirMetricsByDay(long cityId, String day) {
        String key = cityId + "," + day;
        AirMetrics result = cache.getRequest(key);

        if (result == null) {
            result = this.externalApi2.getMetricsByIdAndDay(cityId, day);

            if (result == null) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                        "Request not valid.Please check api token and/or city_id and/or day");
            }
        }

        cache.storeRequest(key, result);
        return result;
    }

    public Cache getCacheStatistics() {
        return cache;
    }
}

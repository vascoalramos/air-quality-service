package tqs.homework.airquality.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tqs.homework.airquality.model.AirMetrics;
import tqs.homework.airquality.model.City;
import tqs.homework.airquality.model.Data;
import tqs.homework.airquality.model.CityCollection;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vasco Ramos
 * @date 06/04/20
 * @time 16:32
 */

@Repository
public class BreezoMeeterRepository {
    private static final Logger logger = Logger.getLogger(BreezoMeeterRepository.class.getName());
    private static final String BASE_URL = "https://api.breezometer.com/air-quality/v2/";
    private static final String TOKEN = "af63fcc516384a9fad810ec4e021a3a0";

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    private CityCollection cityCollection = new CityCollection();

    public AirMetrics getCurrentMetricsById(long cityId) {
        AirMetrics result = null;
        try {
            City city = cityCollection.getCityById(cityId);
            String url = BASE_URL + "current-conditions" + "?lat=" + city.getLat() + "&lon=" + city.getLon()
                    + "&key=" + TOKEN + "&features=breezometer_aqi,pollutants_aqi_information&metadata=true";
            ResponseEntity<String> response = fetchInfo(url);

            if (response.getStatusCode() == HttpStatus.OK) {
                result = getAirMetricsResponse(response, city);
            } else {
                throw new IllegalStateException("Something failed while fetching the request. Status code: "
                        + response.getStatusCode());
            }

        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.toString());
        }

        return result;
    }

    public AirMetrics getMetricsByIdAndDay(long cityId, String date) {
        AirMetrics result = null;
        try {
            City city = cityCollection.getCityById(cityId);
            String urlString = BASE_URL + "historical/hourly" + "?lat=" + city.getLat() + "&lon=" + city.getLon()
                    + "&start_datetime=" + date + "T00:00:00&end_datetime=" + date + "T01:00:00"
                    + "&key=" + TOKEN + "&features=breezometer_aqi,pollutants_aqi_information&metadata=true";

            URL url = new URL(urlString);

            ResponseEntity<String> response = fetchInfo(url.toString());

            if (response.getStatusCode() == HttpStatus.OK) {
                result = getAirMetricsResponse(response, city);
            } else {
                throw new IllegalStateException("Something failed while fetching the request. Status code: "
                        + response.getStatusCode());
            }

        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.toString());
        }

        return result;
    }

    private ResponseEntity<String> fetchInfo(String url) {
        return this.restTemplate.getForEntity(url, String.class);
    }

    private AirMetrics getAirMetricsResponse(ResponseEntity<String> response, City c) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode responseBody = mapper.readTree(response.getBody());
        JsonNode data = responseBody.at("/data");

        if (data.isArray()) {
            data = data.get(data.size() - 1);
        }

        double aqi = data.at("/indexes/baqi/aqi").asDouble();

        JsonNode pollutants = data.at("/pollutants");
        double o3 = pollutants.at("/o3/aqi_information/baqi/aqi").asDouble();
        double co = pollutants.at("/co/aqi_information/baqi/aqi").asDouble();
        double no2 = pollutants.at("/no2/aqi_information/baqi/aqi").asDouble();
        double pm10 = pollutants.at("/pm10/aqi_information/baqi/aqi").asDouble();
        double pm25 = pollutants.at("/pm25/aqi_information/baqi/aqi").asDouble();
        double so2 = pollutants.at("/so2/aqi_information/baqi/aqi").asDouble();

        AirMetrics airMetrics = new AirMetrics();
        Data[] dataArray = new Data[1];
        dataArray[0] = new Data();
        dataArray[0].setAqi(aqi);
        dataArray[0].setO3(o3);
        dataArray[0].setSo2(so2);
        dataArray[0].setNo2(no2);
        dataArray[0].setCo(co);
        dataArray[0].setPm10(pm10);
        dataArray[0].setPm25(pm25);

        airMetrics.setMetrics(dataArray);

        airMetrics.setLon(Double.parseDouble(c.getLon()));
        airMetrics.setLat(Double.parseDouble(c.getLat()));

        String[] cityInfo = c.getText().split(",");
        airMetrics.setCityName(cityInfo[0]);
        airMetrics.setCountryCode(cityInfo[1]);

        return airMetrics;
    }
}

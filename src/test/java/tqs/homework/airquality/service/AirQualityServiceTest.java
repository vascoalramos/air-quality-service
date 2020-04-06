package tqs.homework.airquality.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tqs.homework.airquality.model.AirMetrics;
import tqs.homework.airquality.repository.WeatherBitRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 14:37
 */

@ExtendWith(MockitoExtension.class)
public class AirQualityServiceTest {

    private long CITY_ID = 2732265L;

    @Mock
    private WeatherBitRepository repository;

    @InjectMocks
    private AirQualityService service;

    @Test
    public void whenGetAirMetrics_thenReturnCorrectMetrics() throws Exception {
        AirMetrics response = loadRequest();

        String url = "https://api.weatherbit.io/v2.0/current/airquality?city_id=2732265&key=0fc2afb40f3d46859bbb4b64f7ea7eb3";
        when(repository.getMetrics(CITY_ID)).thenReturn(response);

        assertThat(service.getCurrentAirMetrics(CITY_ID)).isInstanceOf(AirMetrics.class);

        reset(repository);
    }

    private AirMetrics loadRequest() throws JsonProcessingException {
        String sampleJson = "{\"lat\":40.66101,\"lon\":-7.90971,\"timezone\":\"Europe/Lisbon\",\"city_name\":\"Viseu\",\"country_code\":\"PT\",\"state_code\":\"22\",\"data\":[{\"aqi\":34.0,\"o3\":74.0,\"so2\":1.16043,\"no2\":5.0,\"co\":342.548,\"pm10\":3.0,\"pm25\":2.89888}]}";
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(sampleJson, AirMetrics.class);
    }
}

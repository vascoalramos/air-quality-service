package tqs.homework.airquality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import tqs.homework.airquality.model.AirMetrics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 14:37
 */

@ExtendWith(MockitoExtension.class)
public class WeatherBitServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherBitService service;

    @Test
    public void whenGetAirMetrics_thenReturnCorrectMetrics() throws Exception {
        String sampleJson = "{\"lat\":40.66101,\"lon\":-7.90971,\"timezone\":\"Europe/Lisbon\",\"city_name\":\"Viseu\",\"country_code\":\"PT\",\"state_code\":\"22\",\"data\":[{\"aqi\":34.0,\"o3\":74.0,\"so2\":1.16043,\"no2\":5.0,\"co\":342.548,\"pm10\":3.0,\"pm25\":2.89888}]}";
        ObjectMapper mapper = new ObjectMapper();
        AirMetrics response = mapper.readValue(sampleJson, AirMetrics.class);

        String url = "https://api.weatherbit.io/v2.0/current/airquality?city=Viseu,PT&key=0fc2afb40f3d46859bbb4b64f7ea7eb3";
        when(restTemplate.getForObject(url, AirMetrics.class)).thenReturn(response);

        assertThat(service.getCurrentAirMetrics()).isInstanceOf(AirMetrics.class);

        reset(restTemplate);
    }
}

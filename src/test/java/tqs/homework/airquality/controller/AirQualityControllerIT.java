package tqs.homework.airquality.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tqs.homework.airquality.AirQualityApplication;
import tqs.homework.airquality.model.AirMetrics;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 15:46
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AirQualityApplication.class)
@AutoConfigureMockMvc
public class AirQualityControllerIT {

    private long CITY_ID = 2732265L;

    @Autowired
    private MockMvc servlet;

    @Test
    public void whenGetCar_thenReturnCar() throws Exception {
        String sampleJson = "{\"lat\":40.66101,\"lon\":-7.90971,\"timezone\":\"Europe/Lisbon\",\"city_name\":\"Viseu\",\"country_code\":\"PT\",\"state_code\":\"22\",\"data\":[{\"aqi\":34.0,\"o3\":74.0,\"so2\":1.16043,\"no2\":5.0,\"co\":342.548,\"pm10\":3.0,\"pm25\":2.89888}]}";
        ObjectMapper mapper = new ObjectMapper();
        AirMetrics response = mapper.readValue(sampleJson, AirMetrics.class);

        servlet.perform(get("/api/air-metrics?city_id=" + CITY_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("lat", is(response.getLat())))
                .andExpect(jsonPath("lon", is(response.getLon())))
                .andExpect(jsonPath("timezone", is(response.getTimezone())))
                .andExpect(jsonPath("country_code", is(response.getCountry_code())))
                .andExpect(jsonPath("city_name", is(response.getCity_name())))
                .andExpect(jsonPath("state_code", is(response.getState_code())));
    }
}

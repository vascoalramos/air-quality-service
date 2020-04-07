package tqs.homework.airquality.controller.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import tqs.homework.airquality.AirQualityApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 11:38
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AirQualityApplication.class)
@AutoConfigureMockMvc
public class AirMetricsByDayControllerIT {

    @Autowired
    private MockMvc servlet;

    @Test
    public void testGetRequest() throws Exception {
        this.servlet.perform(get("/by-day"))
                .andExpect(status().isOk())
                .andExpect(view().name("by-day"));
    }
}

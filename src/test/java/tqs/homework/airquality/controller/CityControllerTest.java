package tqs.homework.airquality.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tqs.homework.airquality.model.City;
import tqs.homework.airquality.service.CityService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Vasco Ramos
 * @date 02/04/20
 * @time 19:15
 */

@WebMvcTest(CityController.class)
public class CityControllerTest {

    @Autowired
    private MockMvc servlet;

    @MockBean
    private CityService cityService;

    @Test
    public void whenGetCity_thenReturnCity() throws Exception {
        City viseu = new City(123, "Viseu", "PT", "Portugal");

        given(cityService.getCityDetails("Viseu")).willReturn(viseu);

        servlet.perform(get("/cities").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        reset(cityService);

    }
}

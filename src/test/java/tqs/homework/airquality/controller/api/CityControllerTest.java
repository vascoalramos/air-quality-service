package tqs.homework.airquality.controller.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    @Test
    public void whenGetCities_thenReturnCities() throws Exception {
        this.servlet.perform(get("/api/cities").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void whenGetCitiesValidQuery_thenReturnCities() throws Exception {
        this.servlet.perform(get("/api/cities?q=vise").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void whenGetCitiesInvalidQuery_thenReturnEmptyCities() throws Exception {
        this.servlet.perform(get("/api/cities?q=1912192_q").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}

package tqs.homework.airquality.controller.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 11:38
 */

@WebMvcTest(CacheController.class)
public class CacheControllerTest {

    @Autowired
    private MockMvc servlet;

    @Test
    public void testGetRequest() throws Exception {
        this.servlet.perform(get("/cache-statistics"))
                .andExpect(status().isOk())
                .andExpect(view().name("cache-statistics"));
    }
}

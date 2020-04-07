package tqs.homework.airquality.controller.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import tqs.homework.airquality.controller.web.IndexController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 11:38
 */

@WebMvcTest(IndexController.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc servlet;

    @Test
    public void testListProducts() throws Exception {
        this.servlet.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testPostRequest() throws Exception {
        this.servlet.perform(post("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("air-metrics"));
    }
}

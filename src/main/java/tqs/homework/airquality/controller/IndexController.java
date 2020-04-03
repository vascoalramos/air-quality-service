package tqs.homework.airquality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 10:50
 */

@Controller
@RequestMapping({ "/", "/index" })
public class IndexController {

    @GetMapping
    public String getIndex() {
        return "index";
    }
}

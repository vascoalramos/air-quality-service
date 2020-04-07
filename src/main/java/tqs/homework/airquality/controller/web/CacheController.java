package tqs.homework.airquality.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vasco Ramos
 * @date 07/04/20
 * @time 13:30
 */

@Controller
@RequestMapping({"/cache-statistics"})
public class CacheController {

    @GetMapping
    public String getCacheStatistics() {
        return "cache-statistics";
    }
}

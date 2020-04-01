package tqs.homework.airquality;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tqs.homework.airquality.model.City;
import tqs.homework.airquality.repository.CityRepository;
import tqs.homework.airquality.utils.CSVReader;

@SpringBootApplication
public class AirqualityApplication {

    @Autowired
    private CityRepository cityRepository;

    public static void main(String[] args) {
        SpringApplication.run(AirqualityApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            for (City city : new CSVReader().readFIle()) {
                cityRepository.save(city);
            }
        };
    }
}

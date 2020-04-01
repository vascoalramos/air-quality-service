package tqs.homework.airquality.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tqs.homework.airquality.model.City;
import tqs.homework.airquality.repository.CityRepository;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 22:43
 */

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City getCityDetails(String name) {
        return cityRepository.findCityByName(name);
    }
}

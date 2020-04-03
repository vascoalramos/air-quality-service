package tqs.homework.airquality.utils;

import tqs.homework.airquality.model.City;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vasco Ramos
 * @date 02/04/20
 * @time 21:14
 */

public class CityCollection {
    private List<City> cities;

    public CityCollection() {
        this.cities = new ArrayList<>();
        this.cities.addAll(new CSVReader().readFIle());
    }

    public List<City> getAllCities() {
        return this.cities;
    }

    public List<City> getCitiesContains(String query) {
        String finalQuery = query.toLowerCase();
        return this.cities.stream()
                .filter(city -> city.getText().toLowerCase().contains(finalQuery))
                .limit(15)
                .collect(Collectors.toList());
    }
}

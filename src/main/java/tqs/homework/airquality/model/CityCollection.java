package tqs.homework.airquality.model;

import tqs.homework.airquality.utils.CSVReader;

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
        return this.cities.stream().limit(25).collect(Collectors.toList());
    }

    public List<City> getCitiesContains(String query) {
        String finalQuery = query.toLowerCase();
        return this.cities.stream()
                .filter(city -> city.getText().toLowerCase().contains(finalQuery))
                .limit(25)
                .collect(Collectors.toList());
    }

    public City getCityById(long id) {
        return this.cities.stream()
                .filter(city -> city.getId() == id)
                .limit(1)
                .collect(Collectors.toList()).get(0);
    }
}

package tqs.homework.airquality.utils;

import org.junit.jupiter.api.Test;
import tqs.homework.airquality.model.City;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vasco Ramos
 * @date 06/04/20
 * @time 14:25
 */

public class CityCollectionTest {

    private CityCollection cityCollection = new CityCollection();

    @Test
    public void testGetAllCities() {
        assertThat(cityCollection.getAllCities()).isNotNull();
        assertThat(cityCollection.getAllCities()).isInstanceOf(List.class);
        assertThat(cityCollection.getAllCities()).hasSize(25);
        cityCollection.getAllCities().forEach(city -> assertThat(city).isInstanceOf(City.class));
    }

    @Test
    public void testGetCitiesContainsValidName() {
        String name = "Viseu";
        assertThat(cityCollection.getCitiesContains(name)).isNotNull();
        assertThat(cityCollection.getCitiesContains(name)).isInstanceOf(List.class);
        assertThat(cityCollection.getCitiesContains(name)).hasSizeLessThanOrEqualTo(25);
        cityCollection.getCitiesContains(name).forEach(city -> assertThat(city).isInstanceOf(City.class));
    }

    @Test
    public void testGetCitiesContainsInvalidName() {
        String name = "ASd_1235";
        assertThat(cityCollection.getCitiesContains(name)).isNullOrEmpty();
    }
}

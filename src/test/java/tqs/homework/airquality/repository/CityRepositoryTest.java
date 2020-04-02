package tqs.homework.airquality.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import tqs.homework.airquality.model.City;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 21:49
 */

@DataJpaTest
public class CityRepositoryTest {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindById_thenReturnCity() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);

        City found = cityRepository.findByCityId(viseu.getCityId());
        assertThat(found.getName()).isEqualTo(viseu.getName());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        City found = cityRepository.findByCityId(2L);
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByName_thenReturnCity() {
        City city = new City(123, "Canas de Senhorim", "PT", "Portugal");
        entityManager.persistAndFlush(city);

        City found = cityRepository.findByName(city.getName());
        assertThat(found.getName()).isEqualTo(city.getName());
    }

    @Test
    public void whenInvalidName_thenReturnNull() {
        City found = cityRepository.findByName("Invalid City");
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByCountry_thenReturnCityList() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);

        List<City> found = cityRepository.findByCountry(viseu.getCountry());
        assertThat(found).isNotNull();
    }

    @Test
    public void whenInvalidCountry_thenReturnNull() {
        List<City> found = cityRepository.findByCountry("Invalid Country");
        assertThat(found).isEqualTo(new ArrayList<City>());
    }

    @Test
    public void whenFindByCountryCode_thenReturnCityList() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);

        List<City> found = cityRepository.findByCountryCode(viseu.getCountryCode());
        assertThat(found).isNotNull();
    }

    @Test
    public void whenInvalidCountryCode_thenReturnNull() {
        List<City> found = cityRepository.findByCountryCode("Invalid Code");
        assertThat(found).isEmpty();
    }

    @Test
    public void whenFindByNameContains_thenReturnCityList() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);
        List<City> found = cityRepository.findCitiesByNameContainsIgnoreCase("vise");
        assertThat(found).isNotNull();
    }

    @Test
    public void whenInvalidNamePart_thenReturnNull() {
        List<City> found = cityRepository.findCitiesByNameContainsIgnoreCase("1232");
        assertThat(found).isEmpty();
    }

}
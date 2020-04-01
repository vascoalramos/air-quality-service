package tqs.homework.airquality;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import tqs.homework.airquality.model.City;
import tqs.homework.airquality.repository.CityRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    public void whenFindById_thenReturnCar() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);

        Optional<City> found = cityRepository.findById(viseu.getCityId());
        assertThat((found.get().getName())).isEqualTo(viseu.getName());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        Optional<City> found = cityRepository.findById(2L);
        assertNull(found.get());
    }

    @Test
    public void whenFindByName_thenReturnCar() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);

        City found = cityRepository.findCityByName(viseu.getName());
        assertThat((found.getName())).isEqualTo(viseu.getName());
    }

    @Test
    public void whenInvalidName_thenReturnNull() {
        City found = cityRepository.findCityByName("Invalid City");
        assertNull(found);
    }

    @Test
    public void whenFindByCountry_thenReturnCar() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);

        List<City> found = cityRepository.findCitiesByCountry(viseu.getCountry());
        assertNotNull((found));
    }

    @Test
    public void whenInvalidCountry_thenReturnNull() {
        List<City> found = cityRepository.findCitiesByCountry("Invalid Country");
        assertNull(found);
    }

    @Test
    public void whenFindByCountryCode_thenReturnCar() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);

        List<City> found = cityRepository.findCitiesByCountryCode(viseu.getCountryCode());
        assertNotNull((found));
    }

    @Test
    public void whenInvalidCountryCode_thenReturnNull() {
        List<City> found = cityRepository.findCitiesByCountryCode("Invalid Code");
        assertNull(found);
    }

}
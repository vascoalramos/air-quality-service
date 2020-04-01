package tqs.homework.airquality.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import tqs.homework.airquality.model.City;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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
    void whenFindById_thenReturnCar() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);

        Optional<City> found = cityRepository.findById(viseu.getCityId());
        assertThat((found.get().getName())).isEqualTo(viseu.getName());
    }

    @Test
    void whenInvalidId_thenReturnNull() {
        Optional<City> found = cityRepository.findById(2L);
        assertNull(found.get());
    }

    @Test
    void whenFindByName_thenReturnCar() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        entityManager.persistAndFlush(viseu);

        City found = cityRepository.findCityByName(viseu.getName());
        assertThat((found.getName())).isEqualTo(viseu.getName());
    }

    @Test
    void whenInvalidName_thenReturnNull() {
        City found = cityRepository.findCityByName("Invalid City");
        assertNull(found);
    }

}
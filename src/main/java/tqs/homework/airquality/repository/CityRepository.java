package tqs.homework.airquality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tqs.homework.airquality.model.City;

import java.util.List;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 19:52
 */

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByCityId(long id);

    City findByName(String name);

    List<City> findByCountry(String country);

    List<City> findByCountryCode(String countryCode);
}

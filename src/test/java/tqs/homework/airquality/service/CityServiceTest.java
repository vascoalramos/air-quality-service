package tqs.homework.airquality.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import tqs.homework.airquality.model.City;
import tqs.homework.airquality.repository.CityRepository;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 22:45
 */

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {

    @Mock(lenient = true)
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;


    @BeforeEach
    public void setUp() {
        City viseu = new City(123, "Viseu", "PT", "Portugal");
        Mockito.when(cityRepository.findCityByName(viseu.getName())).thenReturn(viseu);
    }

    @Test
    void whenValidName_thenCityShouldBeFound() {
        String name = "mustang";

        City found = cityService.getCityDetails(name);

        assertThat(found.getName()).isEqualTo(name);
    }

    @Test
    void whenNonExistingName_thenCityShouldNotExist() {
        String name = "ABC";

        City found = cityService.getCityDetails(name);

        assertThat(found).isNull();

        verifyFindByNameIsCalledOnce(name);
    }

    private void verifyFindByNameIsCalledOnce(String name) {
        Mockito.verify(cityRepository, VerificationModeFactory.times(1)).findCityByName(name);
        Mockito.reset(cityRepository);
    }
}

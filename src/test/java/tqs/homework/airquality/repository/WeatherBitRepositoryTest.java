package tqs.homework.airquality.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import tqs.homework.airquality.model.AirMetrics;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vasco Ramos
 * @date 06/04/20
 * @time 13:20
 */

@ExtendWith(MockitoExtension.class)
public class WeatherBitRepositoryTest {

    private static  final long CITY_ID = 2732265L;

    @InjectMocks
    private WeatherBitRepository repository;

    @Test
    public void whenGetAirMetrics_thenReturnCorrectMetrics() {
        assertThat(repository.getMetrics(CITY_ID)).isInstanceOf(AirMetrics.class);
    }
}

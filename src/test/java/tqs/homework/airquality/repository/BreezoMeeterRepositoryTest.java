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
 * @time 18:05
 */

@ExtendWith(MockitoExtension.class)
public class BreezoMeeterRepositoryTest {
    private static  final long CITY_ID = 2732265L;

    @InjectMocks
    private BreezoMeeterRepository repository;

    @Test
    public void whenGetCurrentAirMetricsValidId_thenReturnCorrectMetrics() {
        assertThat(repository.getCurrentMetricsById(CITY_ID)).isInstanceOf(AirMetrics.class);
    }

    @Test
    public void whenGetCurrentAirMetricsInvalidId_thenReturnCorrectMetrics() {
        assertThat(repository.getCurrentMetricsById(1L)).isNull();
    }

    @Test
    public void whenGetAirMetricsValidIdAndDay_thenReturnCorrectMetrics() {
        assertThat(repository.getMetricsByIdAndDay(CITY_ID, "2020-04-05")).isInstanceOf(AirMetrics.class);
    }

    @Test
    public void whenGetAirMetricsValidIdAndInvalidDay_thenReturnCorrectMetrics() {
        assertThat(repository.getMetricsByIdAndDay(CITY_ID, "2020-04-40")).isNull();
    }

    @Test
    public void whenGetAirMetricsInvalidIdAndDay_thenReturnCorrectMetrics() {
        assertThat(repository.getMetricsByIdAndDay(1L, "2020-04-40")).isNull();
    }
}

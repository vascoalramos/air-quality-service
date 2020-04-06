package tqs.homework.airquality.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 11:43
 */


public class CityTest {

    @Test
    public void testCompareToGreater() {
        City city1 = new City(1L, "Viseu,PT", "Portugal");
        City city2 = new City(2L, "Nelas,PT", "Portugal");
        assertThat(city1.compareTo(city2)).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void testCompareToSmaller() {
        City city1 = new City(1L, "Viseu,PT", "Portugal");
        City city2 = new City(2L, "Nelas,PT", "Portugal");
        assertThat(city2.compareTo(city1)).isLessThanOrEqualTo(-1);
    }

    @Test
    public void testCompareToEqual() {
        City city1 = new City(1L, "Viseu,PT", "Portugal");
        City city2 = new City(2L, "Viseu,PT", "Portugal");
        assertThat(city1.compareTo(city2)).isEqualTo(0);
    }
}

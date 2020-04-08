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
        City city1 = new City(1L, "Viseu,PT", "Portugal", "222", "-1.2");
        City city2 = new City(2L, "Nelas,PT", "Portugal", "222", "-1.2");
        assertThat(city1.compareTo(city2)).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void testCompareToSmaller() {
        City city1 = new City(1L, "Viseu,PT", "Portugal", "222", "-1.2");
        City city2 = new City(2L, "Nelas,PT", "Portugal", "222", "-1.2");
        assertThat(city2.compareTo(city1)).isLessThanOrEqualTo(-1);
    }

    @Test
    public void testCompareToEqual() {
        City city1 = new City(1L, "Viseu,PT", "Portugal", "222", "-1.2");
        City city2 = new City(2L, "Viseu,PT", "Portugal", "222", "-1.2");
        assertThat(city1.compareTo(city2)).isEqualTo(0);
    }

    @Test
    public void testSetId() {
        City city = new City(1L, "Viseu,PT", "Portugal", "222", "-1.2");
        long newId = 10L;
        city.setId(newId);
        assertThat(city.getId()).isEqualTo(newId);
    }

    @Test
    public void testSetText() {
        City city = new City(1L, "Viseu,PT", "Portugal", "222", "-1.2");
        String newText = "Aveiro, PT";
        city.setText(newText);
        assertThat(city.getText()).isEqualTo(newText);
    }

    @Test
    public void testSetCountry() {
        City city = new City(1L, "Viseu,PT", "Portugal", "222", "-1.2");
        String newCountry = "Espanha";
        city.setCountry(newCountry);
        assertThat(city.getCountry()).isEqualTo(newCountry);
    }

    @Test
    public void testSetLat() {
        City city = new City(1L, "Viseu,PT", "Portugal", "222", "-1.2");
        String newLat = "111";
        city.setLat(newLat);
        assertThat(city.getLat()).isEqualTo(newLat);
    }

    @Test
    public void testSetLong() {
        City city = new City(1L, "Viseu,PT", "Portugal", "222", "-1.2");
        String newLon = "111";
        city.setLon(newLon);
        assertThat(city.getLon()).isEqualTo(newLon);
    }
}

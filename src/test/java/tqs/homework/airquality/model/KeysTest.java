package tqs.homework.airquality.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KeysTest {

    @Test
    public void testSetDay() {
        Keys keys = new Keys();
        String day = "day1";
        keys.setDay(day);
        assertThat(keys.getDay()).isEqualTo(day);
    }

    @Test
    public void testSetCity() {
        City city = new City(1L, "Viseu,PT", "Portugal", "222", "-1.2");
        Keys keys = new Keys();
        keys.setCity(city);
        assertThat(keys.getCity()).isEqualTo(city);
    }
}

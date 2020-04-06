package tqs.homework.airquality.utils;

import org.junit.jupiter.api.Test;
import tqs.homework.airquality.model.City;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vasco Ramos
 * @date 06/04/20
 * @time 14:18
 */

public class CSVReaderTest {

    private CSVReader reader = new CSVReader();

    @Test
    public void testReaderIsNotNull() {
        assertThat(reader.readFIle()).isNotNull();
    }

    @Test
    public void testReaderIsInstanceOfList() {
        assertThat(reader.readFIle()).isInstanceOf(List.class);
    }

    @Test
    public void testReaderIsListOfCities() {
        reader.readFIle().forEach(city -> assertThat(city).isInstanceOf(City.class));
    }
}

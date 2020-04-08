package tqs.homework.airquality.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tqs.homework.airquality.model.AirMetrics;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vasco Ramos
 * @date 06/04/20
 * @time 11:30
 */

public class CacheTest {

    private static final String CITY_ID = "2732265";

    private Cache cache;

    @BeforeEach
    private void init() {
        cache = new Cache(2L);

        assertThat(cache.getNumberOfRequests()).isEqualTo(0);
        assertThat(cache.getNumberOfHits()).isEqualTo(0);
        assertThat(cache.getNumberOfMisses()).isEqualTo(0);
    }

    @Test
    public void whenRequestDoesNotExist_thenIncrementMisses() {
        assertThat(cache.getRequest("non_existent_request")).isNull();

        assertThat(cache.getNumberOfRequests()).isEqualTo(1);
        assertThat(cache.getNumberOfHits()).isEqualTo(0);
        assertThat(cache.getNumberOfMisses()).isEqualTo(1);
    }

    @Test
    public void whenRequestExists_thenReturnsRequestAndIncrementsHits() throws JsonProcessingException {
        AirMetrics request = loadRequest();
        cache.storeRequest(CITY_ID, request);
        assertThat(cache.getRequest(CITY_ID)).isNotNull();

        assertThat(cache.getNumberOfRequests()).isEqualTo(1);
        assertThat(cache.getNumberOfHits()).isEqualTo(1);
        assertThat(cache.getNumberOfMisses()).isEqualTo(0);
    }

    @Test
    public void whenRequestExpired_thenReturnsRequestAndIncrementsMisses() throws JsonProcessingException, InterruptedException {
        AirMetrics request = loadRequest();
        cache.storeRequest(CITY_ID, request);

        // expiration time
        TimeUnit.SECONDS.sleep(3);

        assertThat(cache.getRequest(CITY_ID)).isNull();

        assertThat(cache.getNumberOfRequests()).isEqualTo(1);
        assertThat(cache.getNumberOfHits()).isEqualTo(0);
        assertThat(cache.getNumberOfMisses()).isEqualTo(1);
    }

    private AirMetrics loadRequest() throws JsonProcessingException {
        String sampleJson = "{\"lat\":40.66101,\"lon\":-7.90971,\"timezone\":\"Europe/Lisbon\",\"city_name\":\"Viseu\",\"country_code\":\"PT\",\"state_code\":\"22\",\"data\":[{\"aqi\":34.0,\"o3\":74.0,\"so2\":1.16043,\"no2\":5.0,\"co\":342.548,\"pm10\":3.0,\"pm25\":2.89888}]}";
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(sampleJson, AirMetrics.class);
    }
}

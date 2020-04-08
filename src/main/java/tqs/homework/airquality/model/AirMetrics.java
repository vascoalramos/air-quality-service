package tqs.homework.airquality.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:35
 */

@Getter
@Setter
public class AirMetrics implements Serializable {

    private double lat;
    private double lon;
    private String timezone;


    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("state_code")
    private String stateCode;

    @JsonProperty("data")
    private Data[] metrics;
}

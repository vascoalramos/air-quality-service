package tqs.homework.airquality.model;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:35
 */

@Getter
public class AirMetrics implements Serializable {

    private double lat;
    private double lon;
    private String timezone;
    private String city_name;
    private String country_code;
    private String state_code;
    private Data[] data;

}

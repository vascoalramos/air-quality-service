package tqs.homework.airquality.model;

import java.io.Serializable;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:35
 */

public class AirMetrics implements Serializable {

    private double lat;
    private double lon;
    private String timezone;
    private String city_name;
    private String country_code;
    private String state_code;
    private Data[] data;

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getCity_name() {
        return city_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getState_code() {
        return state_code;
    }

    public Data[] getData() {
        return data;
    }
}

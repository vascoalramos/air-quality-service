package tqs.homework.airquality.model;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:35
 */

public class City {
    private long cityId;
    private String name;
    private String countryCode;
    private String country;

    public City(long cityId, String name, String countryCode, String country) {
        this.cityId = cityId;
        this.name = name;
        this.countryCode = countryCode;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public long getCityId() {
        return cityId;
    }
}

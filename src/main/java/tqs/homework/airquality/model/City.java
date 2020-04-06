package tqs.homework.airquality.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:35
 */

@Setter
@Getter
public class City implements Comparable<City> {
    private long id;
    private String text;
    private String country;
    private String lat;
    private String lon;

    public City() {
    }

    public City(long cityId, String text, String country, String lat, String lon) {
        this.id = cityId;
        this.text = text;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public int compareTo(City city) {
        return this.text.compareToIgnoreCase(city.text);
    }

}

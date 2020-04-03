package tqs.homework.airquality.model;

import lombok.Setter;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:35
 */

@Setter
public class City implements Comparable<City> {
    private long id;
    private String text;
    private String country;

    public City() {
    }

    public City(long cityId, String text, String country) {
        this.id = cityId;
        this.text = text;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(City city) {
        return this.text.compareToIgnoreCase(city.text);
    }

}

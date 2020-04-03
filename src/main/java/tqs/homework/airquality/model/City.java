package tqs.homework.airquality.model;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:35
 */

public class City implements Comparable<City> {
    private long id;
    private String name;
    private String countryCode;
    private String country;

    public City(long cityId, String name, String countryCode, String country) {
        this.id = cityId;
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

    public String getText() {
        return name + ", " + country;
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(City city) {
        return this.name.compareToIgnoreCase(city.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof City)) {
            return false;
        }

        City city = (City) obj;

        // Compare the data members and return accordingly
        return this.name.equals(city.name);
    }
}

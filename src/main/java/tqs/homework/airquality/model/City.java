package tqs.homework.airquality.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Vasco Ramos
 * @date 01/04/20
 * @time 17:35
 */

@Entity
@Data
public class City {

    @Id
    private long cityId;

    @Column
    private String name;

    @Column
    private String countryCode;

    @Column
    private String country;

    public City() {
    }

    public City(long cityId, String name, String countryCode, String country) {
        this.cityId = cityId;
        this.name = name;
        this.countryCode = countryCode;
        this.country = country;
    }
}

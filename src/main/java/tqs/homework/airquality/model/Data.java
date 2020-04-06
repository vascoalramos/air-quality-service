package tqs.homework.airquality.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 12:44
 */

@Getter
@Setter
public class Data implements Serializable {
    private double aqi;
    private double o3;
    private double so2;
    private double no2;
    private double co;
    private double pm10;
    private double pm25;
}

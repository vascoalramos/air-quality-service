package tqs.homework.airquality.model;

import java.io.Serializable;

/**
 * @author Vasco Ramos
 * @date 03/04/20
 * @time 12:44
 */

public class Data implements Serializable {
    private double aqi;
    private double o3;
    private double so2;
    private double no2;
    private double co;
    private double pm10;
    private double pm25;

    public double getAqi() {
        return aqi;
    }

    public double getO3() {
        return o3;
    }

    public double getSo2() {
        return so2;
    }

    public double getNo2() {
        return no2;
    }

    public double getCo() {
        return co;
    }

    public double getPm10() {
        return pm10;
    }

    public double getPm25() {
        return pm25;
    }
}

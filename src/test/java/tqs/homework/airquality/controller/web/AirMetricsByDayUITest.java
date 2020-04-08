package tqs.homework.airquality.controller.web;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AirMetricsByDayUITest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAirMetricsByDay() {
        driver.get("http://127.0.0.1:8080/");
        driver.manage().window().setSize(new Dimension(1920, 985));
        driver.findElement(By.linkText("By Day")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 90);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-city-container")));
        }
        driver.findElement(By.id("select2-city-container")).click();
        driver.findElement(By.cssSelector("ul.select2-results__options li.select2-results__option:nth-child(1)")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.textToBe(By.id("select2-city-container"), "Comugne,IT"));
        }
        driver.findElement(By.id("day")).click();
        driver.findElement(By.cssSelector(".today:nth-child(4)")).click();
        driver.findElement(By.id("submit")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 90);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city_text")));
        }
        assertThat(driver.findElement(By.id("city_text")).getText(), is("COMUGNE, IT"));
        assertThat(driver.findElement(By.cssSelector(".mt-2")).getText(), is("ANALYSE SOME METRICS CONCERNING THE CITY'S AIR QUALITY"));
        assertThat(driver.findElement(By.cssSelector(".col-lg-12 b")).getText(), is("Air Quality Index"));
        assertThat(driver.findElement(By.cssSelector(".mt-md-0 b")).getText(), is("Carbon Monoxide (CO)"));
        assertThat(driver.findElement(By.cssSelector(".col-lg-4:nth-child(3) b")).getText(), is("Nitrogen Dioxide (NO2)"));
        assertThat(driver.findElement(By.cssSelector(".col-lg-4:nth-child(4) b")).getText(), is("Ozone (O3)"));
        assertThat(driver.findElement(By.cssSelector(".col-lg-4:nth-child(7) b")).getText(), is("Fine particulate matter (PM2.5)"));
        assertThat(driver.findElement(By.cssSelector(".col-lg-4:nth-child(6) b")).getText(), is("Inhalable particulate matter (PM10)"));
        assertThat(driver.findElement(By.cssSelector(".col-lg-4:nth-child(5) b")).getText(), is("Sulfur Dioxide (SO2)"));
    }
}

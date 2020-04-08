package tqs.homework.airquality.controller.web;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class IndexUITest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ChromeOptions capabilities = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium__standalone-chrome:4444/wd/hub/"), capabilities);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testIndexUI() {
        driver.get("https://tqs-air-quality-service.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1920, 985));
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-city-container")));
        }
        driver.findElement(By.id("select2-city-container")).click();
        driver.findElement(By.cssSelector("ul.select2-results__options li.select2-results__option:nth-child(1)")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.textToBe(By.id("select2-city-container"), "Comugne,IT"));
        }
        driver.findElement(By.id("submit")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
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

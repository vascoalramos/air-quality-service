package tqs.homework.airquality.controller.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexUITest {

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
    public void indexUITest() {
        driver.get("http://127.0.0.1:8080/");
        driver.manage().window().setSize(new Dimension(1920, 985));
        assertThat(driver.findElement(By.cssSelector("a > span")).getText(), is("Air Quality App"));
        assertThat(driver.findElement(By.linkText("By City")).getText(), is("By City"));
        assertThat(driver.findElement(By.linkText("By Day")).getText(), is("By Day"));
        assertThat(driver.findElement(By.linkText("Cache Statistics")).getText(), is("Cache Statistics"));
        assertThat(driver.findElement(By.id("select2-city-container")).getText(), is("Search city"));
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
        }
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("FEATURES"));
        assertThat(driver.findElement(By.cssSelector("p")).getText(), is("CHECK THE FEATURES"));
        assertThat(driver.findElement(By.linkText("Air Metrics By City")).getText(), is("Air Metrics By City"));
        assertThat(driver.findElement(By.linkText("Air Metrics By City and Day")).getText(), is("Air Metrics By City and Day"));
        assertThat(driver.findElement(By.cssSelector(".col-lg-4:nth-child(3) a")).getText(), is("Cache Statistics"));
        assertThat(driver.findElement(By.cssSelector(".copyright")).getText(), is("© 2020 - Developed with by Vasco Ramos"));
    }
}

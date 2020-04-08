package tqs.homework.airquality.controller.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CacheMetricsUITest {

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
    public void showCacheMetrics() {
        driver.get("http://127.0.0.1:8080/");
        driver.manage().window().setSize(new Dimension(1920, 985));
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cache Statistics")));
        }
        driver.findElement(By.linkText("Cache Statistics")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
        }
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("CACHE STATISTICS"));
        assertThat(driver.findElement(By.cssSelector(".mt-2")).getText(), is("CHECK SOME VALUES ABOUT HIT AND MISS REQUESTS"));
        assertThat(driver.findElement(By.cssSelector(".mt-md-0 b")).getText(), is("Total Hits"));
        assertThat(driver.findElement(By.cssSelector(".mt-lg-0 b")).getText(), is("Total Misses"));
        assertThat(driver.findElement(By.cssSelector(".col-lg-12 b")).getText(), is("Total Requests"));
        driver.findElement(By.linkText("Air Quality App")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4:nth-child(3) a")));
        }
        driver.findElement(By.cssSelector(".col-lg-4:nth-child(3) a")).click();
        driver.findElement(By.linkText("Cache Statistics")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")
            ));
        }
        assertThat(driver.findElement(By.cssSelector(".mt-2")).getText(), is("CHECK SOME VALUES ABOUT HIT AND MISS REQUESTS"));
        assertThat(driver.findElement(By.cssSelector(".mt-md-0 b")).getText(), is("Total Hits"));
        assertThat(driver.findElement(By.cssSelector(".mt-lg-0 b")).getText(), is("Total Misses"));
        assertThat(driver.findElement(By.cssSelector(".col-lg-12 b")).getText(), is("Total Requests"));
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("CACHE STATISTICS"));
    }
}

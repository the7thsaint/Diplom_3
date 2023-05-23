package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageObject.Constants;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;




    @Before
    public void startUp() {

        // WebDriverManager.firefoxdriver().setup();
        // driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Constants.BURGER_MAIN_PAGE);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
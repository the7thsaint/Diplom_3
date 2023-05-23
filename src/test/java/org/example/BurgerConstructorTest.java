package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageObject.Constants;
import org.example.pageObject.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BurgerConstructorTest  {
    WebDriver driver;

    @Before
    public void startUp() {

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


    @Test
    public void testCorrectSelectBreadSection(){
        HomePage homePage = new HomePage(driver);
        homePage.clickFillingSection();
        homePage.clickBreadSection();
        Assert.assertTrue("Выбрана секция с хлебом", homePage.selectBreadSectionButton());
    }

    @Test
    public void testCorrectSelectSauceSection(){
        HomePage homePage = new HomePage(driver);
        homePage.clickSauceSection();
        Assert.assertTrue("Выбрана секция с соусами", homePage.selectSauceSectionButton());
    }

    @Test
    public void testCorrectSelectFillingSection(){
        HomePage homePage = new HomePage(driver);
        homePage.clickFillingSection();
        Assert.assertTrue("Выбрана секция с начинками", homePage.selectFillingSectionButton());
    }




}

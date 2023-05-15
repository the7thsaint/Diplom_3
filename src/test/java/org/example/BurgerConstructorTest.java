package org.example;

import org.example.pageObject.HomePage;
import org.junit.Assert;
import org.junit.Test;


public class BurgerConstructorTest extends BaseTest {


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

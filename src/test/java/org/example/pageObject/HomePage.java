package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static WebDriver driver;
    // Кнопка "Войти в аккаунт"
    private final By mainSignInButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg");
    //кнопка «Личный кабинет»
    private final By myAccount = By.xpath(".//p[(@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет')]");
    //раздел "Булки"
    private final By breadSection = By.xpath(".//span[(@class='text text_type_main-default' and text()='Булки')]");
    //раздел "Соусы"
    private final By sauceSection = By.xpath(".//span[(@class='text text_type_main-default' and text()='Соусы')]");
    //раздел "Начинки"
    private final By fillingSection = By.xpath(".//span[(@class='text text_type_main-default' and text()='Начинки')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void pushMainSighInButton(){driver.findElement(mainSignInButton).click();}
    public void pushMyAccountButton(){driver.findElement(myAccount).click();}
    public boolean selectBreadSectionButton(){
        driver.findElement(breadSection).click();
        return driver.findElement(breadSection).getAttribute("class").contains("current");
    }
    public boolean selectSauceSectionButton(){
        driver.findElement(sauceSection).click();
        return driver.findElement(sauceSection).getAttribute("class").contains("current");
    }
    public boolean selectFillingSectionButton(){
        driver.findElement(fillingSection).click();
        return driver.findElement(fillingSection).getAttribute("class").contains("current");
    }

}

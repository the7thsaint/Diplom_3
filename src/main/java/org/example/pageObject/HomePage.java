package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    // Кнопка "Войти в аккаунт"
    private final By mainSignInButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg");
    //кнопка «Личный кабинет»
    private final By myAccount = By.xpath(".//p[(@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет')]");
    //раздел "Булки"
    private final By breadSection = By.xpath(".//span[text()='Булки']/..");
    //раздел "Соусы"
    private final By sauceSection = By.xpath(".//span[text()='Соусы']/..");
    //раздел "Начинки"
    private final By fillingSection = By.xpath(".//span[text()='Начинки']/..");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void pushMainSighInButton() {
        driver.findElement(mainSignInButton).click();
    }

    public void pushMyAccountButton() {
        driver.findElement(myAccount).click();
    }

    public void clickBreadSection() {
        driver.findElement(breadSection).click();
    }

    public void clickSauceSection() {
        driver.findElement(sauceSection).click();
    }

    public void clickFillingSection() {
        driver.findElement(fillingSection).click();
    }

    public boolean selectBreadSectionButton() {
        return driver.findElement(breadSection).getAttribute("class").contains("current");
    }

    public boolean selectSauceSectionButton() {
        return driver.findElement(sauceSection).getAttribute("class").contains("current");
    }

    public boolean selectFillingSectionButton() {
        return driver.findElement(fillingSection).getAttribute("class").contains("current");
    }

    public void waitingForMainPageLoading() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(mainSignInButton));
    }
}

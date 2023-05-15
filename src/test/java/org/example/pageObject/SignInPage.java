package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;
    private final By userNameInput = By.xpath(".//label[text()='Имя']/..//input");
    private final By userEmailInput = By.xpath(".//label[text()='Email']/..//input");
    private final By userPasswordInput = By.xpath(".//label[text()='Пароль']/..//input");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By wrongPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public void insertUserName(String name){
        driver.findElement(userEmailInput).sendKeys(name);
    }

    public void insertUserEmail(String email){
        driver.findElement(userEmailInput).sendKeys(email);
    }

    public void insertUserPassword(String password){
        driver.findElement(userPasswordInput).sendKeys(password);
    }

    public void clickRegisterButton(){
        driver.findElement(registrationButton).click();
    }

    public boolean checkWrongPasswordMessage(){
        driver.findElement(wrongPasswordMessage).isDisplayed();
    }

}

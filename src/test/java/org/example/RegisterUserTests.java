package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.example.UserInfo.UserInfo;
import org.example.UserInfo.UserRandomizer;
import org.example.UserInfo.UserSteps;
import org.example.pageObject.Constants;
import org.example.pageObject.RegistrationPage;
import org.example.pageObject.SignInPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterUserTests {
    public WebDriver driver;
    public RegistrationPage registrationPage;
    public static String accessToken;
    public SignInPage signInPage;
    public UserInfo userInfo;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        registrationPage = new RegistrationPage(driver);
        RestAssured.baseURI = Constants.BURGER_MAIN_PAGE;
        userInfo = UserRandomizer.userWithRandomData();
        accessToken = UserSteps.createNewUser(userInfo).path("accessToken");
    }

    @After
    public void teardown(){
        driver.quit();
        if(accessToken !=null){
            UserSteps.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void testSuccessRegister(){
        driver.get(Constants.BURGER_MAIN_PAGE+Constants.REGISTER_PAGE);
        registrationPage.insertUserDataAndClick(userInfo);
        assertEquals("Переход на страницу логина", Constants.BURGER_MAIN_PAGE+Constants.LOGIN_PAGE,driver.getCurrentUrl());
    }
    //Фэйкер перестал выдавать уникальные значение, надо подумать как зарандомить еще

    @Test
    @DisplayName("Проверка вывода напдиси о некорректном пароле")
    public void testErrorAfterWrongData(){
        userInfo.setPassword("12345");
        driver.get(Constants.BURGER_MAIN_PAGE+Constants.REGISTER_PAGE);
        registrationPage.insertUserDataAndClick(userInfo);
        assertTrue("Ошибка о некорректном пароле отображается", registrationPage.checkWrongPasswordMessage());
        assertEquals("Пользователь остался на странице с регистрацией", Constants.BURGER_MAIN_PAGE+Constants.REGISTER_PAGE,driver.getCurrentUrl());
    }


}

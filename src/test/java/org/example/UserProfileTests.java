package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.example.UserInfo.UserInfo;
import org.example.UserInfo.UserRandomizer;
import org.example.UserInfo.UserSteps;
import org.example.pageObject.Constants;
import org.example.pageObject.HomePage;
import org.example.pageObject.SignInPage;
import org.example.pageObject.UserProfilePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.example.LoginUserTest.signInPage;
import static org.junit.Assert.assertEquals;

public class UserProfileTests {
    private static String accessToken;
    public WebDriver driver;
    public static UserInfo userInfo;
    public HomePage homePage;
    public UserProfilePage userProfilePage;


    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        userProfilePage = new UserProfilePage(driver);
        RestAssured.baseURI = Constants.BURGER_MAIN_PAGE;
        userInfo = UserRandomizer.userWithRandomData();
        accessToken = UserSteps.createNewUser(userInfo).path("accessToken");
        driver.get(Constants.BURGER_MAIN_PAGE);
        homePage.waitingForMainPageLoading();
        homePage.pushMainSighInButton();
        signInPage.insertCredintalsAndButtonClick(userInfo);
    }

    @After
    public void tearDown(){
        if(accessToken !=null){
            UserSteps.deleteUser(accessToken);
        // Закрой браузер
        driver.quit();
        }
    }

    @Test
    @DisplayName("Выход из профиля кнопкой Выход")
    public void testExitProfile(){
        homePage.pushMyAccountButton();
        //driver.get(Constants.BURGER_MAIN_PAGE+Constants.USER_PROFILE);
        userProfilePage.waitingUserProfileLoad();
        userProfilePage.pushProfileExitButton();
        signInPage.waitingLoginPage();
        assertEquals("Пользователь перешел на страницу логина", Constants.BURGER_MAIN_PAGE+Constants.LOGIN_PAGE,driver.getCurrentUrl());
    }


}

package org.example;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.example.UserInfo.UserInfo;
import org.example.UserInfo.UserRandomizer;
import org.example.UserInfo.UserSteps;
import org.example.pageObject.HomePage;
import org.example.pageObject.SignInPage;
import org.junit.*;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginUserTest extends BaseTest {
    public static UserRandomizer userRandomizer;
    public static UserSteps userSteps;
    public static UserInfo userInfo;
//    public static WebDriver driver;
    public static SignInPage signInPage;
    public static HomePage homePage;
    public static String accessToken;

//    @BeforeClass
//    public static void setUp(){
//        userInfo = new UserInfo();
//        userRandomizer = new UserRandomizer();
//        userInfo = userRandomizer.userWithRandomData();
//        accessToken = userSteps.createNewUser(userInfo).path("accessToken");
//    }
//    @AfterClass
//    public static void deleteTestUsers(){
//        userSteps.deleteUser(accessToken);
//    }


    @Test
    @DisplayName("Авторизация по кнопке Войти в аккаунт")
    public void testLoginFromHomePageLoginButton(){
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        userInfo = new UserInfo();
        userRandomizer = new UserRandomizer();
        userInfo = userRandomizer.userWithRandomData();
//        accessToken = userSteps.createNewUser(userInfo).path("accessToken");
        homePage.waitingForMainPageLoading();
        homePage.pushMainSighInButton();
        signInPage.insertCredintalsAndButtonClick(userInfo);
        assertTrue("Вход выполнен", homePageSuccessLogin());
    }

    @Test
    @DisplayName("Авторизация по кнопке Личный кабинет")
    public void testLoginFromHomePageMyAccountButton(){
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        homePage.waitingForMainPageLoading();
        homePage.pushMyAccountButton();
        signInPage.insertCredintalsAndButtonClick(userInfo);
        assertTrue("Вход выполнен", homePageSuccessLogin());
    }

    @Step
    public boolean homePageSuccessLogin(){
        homePage.waitingForMainPageLoading();
        return homePage.orderButtonIsDisplayed();
    }


}

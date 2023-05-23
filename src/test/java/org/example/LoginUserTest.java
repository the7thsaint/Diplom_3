package org.example;

import org.example.UserInfo.UserInfo;
import org.example.pageObject.HomePage;
import org.example.pageObject.SignInPage;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class LoginUserTest {
    public static UserInfo userInfo;
    public static WebDriver driver;
    public static SignInPage signInPage;
    public static HomePage homePage;
    public String accessToken;

    @Before
    public void setUp(){
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
    }
}

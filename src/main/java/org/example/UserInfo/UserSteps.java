package org.example.UserInfo;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.pageObject.Constants;

import static io.restassured.RestAssured.given;

public class UserSteps {

    @Step("Создание нового пользователя")
    public static Response createNewUser(UserInfo userInfo){
        return given()
                .header("Content-Type", "application/json")
                .body(userInfo)
                .post(Constants.REGISTER);
    }

    @Step("Логин пользователя")
    public static Response loginUser(UserInfo userInfo){
        return given()
                .header("Content-Type", "application/json")
                .body(userInfo)
                .post(Constants.LOGIN);
    }

    @Step("Удаление пользователя")
    public static Response deleteUser(String accessToken){
        return given()
                .header("authorization", accessToken)
                .delete(Constants.USER);
    }


}

package org.example.UserInfo;


import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.pageObject.Constants;

import static io.restassured.RestAssured.given;

public class UserSteps {
    @Step("Создание нового пользователя")
    public Response createNewUser(UserInfo userInfo){
        return given()
                .header("Content-Type", "application/json")
                .body(userInfo)
                .post(Constants.REGISTER);
    }

    @Step("Логин пользователя")
    public Response loginUser(UserInfo userInfo){
        return given()
                .header("Content-Type", "application/json")
                .body(userInfo)
                .post(Constants.LOGIN);
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String accessToken){
        return given()
                .header("authorization", accessToken)
                .delete(Constants.USER);
    }


}

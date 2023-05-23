package org.example.UserInfo;

import io.qameta.allure.Step;
import net.datafaker.Faker;

public class UserRandomizer {
    static Faker faker = new Faker();

    @Step("Создание пользователя со случайными данными")
    public UserInfo userWithRandomData(){
        return new UserInfo(
                faker.name().name(),
                faker.internet().emailAddress(),
                faker.internet().password()
        );
    }
}

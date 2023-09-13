package tests.gui;

import base.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(description = "Кейс Авторизация")
    @Description("Positive login test")
    public void test() {
        loginStep.successLogin(ReadProperties.email(), ReadProperties.password());
    }


    @Test(description = "Проверка создания скрина")
    @Description("Negative login test")
    @Issue("BUG-3321")
    public void test2() {
        loginStep.negativeLogin("somePeople", ReadProperties.password());
        Assert.assertFalse(loginStep.errorText().equals("The email must be a valid email address."));
    }


}

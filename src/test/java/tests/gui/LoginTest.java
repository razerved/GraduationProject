package tests.gui;

import configuration.ReadProperties;
import dataHelper.DataHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;


public class LoginTest {
    private WebDriver driver;
    LoginStep loginStep = new LoginStep(driver);

    @Test(description = "Кейс Авторизация")
    @Description("Positive login test")
    public void test1() {

        loginStep.successLogin(DataHelper.getUser());
    }


    @Test(description = "Проверка создания скрина")
    @Description("Negative login test")
    @Issue("BUG-3321")
    public void test2() {
        loginStep.negativeLogin("somePeople", ReadProperties.password());
        Assert.assertFalse(loginStep.errorText().equals("The email must be a valid email address."));
    }



}
package tests.gui;

import configuration.ReadProperties;
import dataHelper.DataHelper;
import factory.BrowserFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import steps.LoginStep;


public class LoginTest  {
    protected WebDriver driver;
    protected LoginStep loginStep;


    @BeforeMethod
    public void set(ITestContext iTestContext){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        loginStep = new LoginStep(driver);

    }

    @Test(description = "Кейс Авторизация")
    @Description("Positive login test")
    public void test1() {
        driver.get(ReadProperties.getUrl());
        loginStep.successLogin(DataHelper.getUser());
    }


    @Test(description = "Проверка создания скрина")
    @Description("Negative login test")
    @Issue("BUG-3321")
    public void test2() {
        driver.get(ReadProperties.getUrl());
        loginStep.negativeLogin("somePeople", ReadProperties.password());
        Assert.assertFalse(loginStep.errorText().equals("The email must be a valid email address."));
    }


    @AfterMethod
    public void tear(ITestResult result) {
        if (!result.isSuccess()) {
            System.out.println("Make screenshot");
        }
        driver.quit();
    }

}
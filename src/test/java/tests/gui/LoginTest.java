package tests.gui;

import base.BaseTest;
import configuration.ReadProperties;
import dataHelper.DataHelper;
import elements.DialogBorder;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import models.Users;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectsPage;

public class LoginTest extends BaseTest {


    @Test(description = "Кейс Авторизация")
    @Description("Positive login test")
    public void test() {
        loginStep.successLogin(DataHelper.getUser());
    }


    @Test(description = "Проверка создания скрина")
    @Description("Negative login test")
    @Issue("BUG-3321")
    public void test2() {
        loginStep.negativeLogin("somePeople", ReadProperties.password());
        Assert.assertFalse(loginStep.errorText().equals("The email must be a valid email address."));
    }

    @Test(description = "Проверка поля на граничные значения")
    public void test3() {
        var expectedSummary = "1111111111111111111111111111111111111111111111111111111111111111111111111111111";
        var actualSummary = "111111111111111111111111111111111111111111111111111111111111111111111111111111112";
        var projectsPage = new ProjectsPage(driver);

        loginStep.successLogin(DataHelper.getUser());
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.summaryInput().sendKeys(actualSummary);
      //  Assert.assertTrue();



    }
    }
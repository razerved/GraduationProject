package tests.gui;

import base.BaseTest;
import configuration.ReadProperties;
import dataHelper.DataHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginTest extends BaseTest {

    private BaseTest baseTest;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;

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
        projectsPage = new ProjectsPage(driver);

        loginStep.successLogin(DataHelper.getUser());
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.summaryInput().sendKeys(actualSummary);

           // Assert.assertEquals(projectsPage.SummaryInputDialog().equals());
        }

    @Test(description = "Проверка возможности создания проекта")
    public void test4(){
        projectsPage = new ProjectsPage(driver);

        loginStep.successLogin(DataHelper.getUser());
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.waitProjectDialogWindow().sendKeys("first");
        projectsPage.submitButton().click();
        Assert.assertTrue(projectsPage.waitProjectDialogWindow() != null);
    }

    @Test(description = "Проверка возможности удаления проекта")
    public void test5(){
        projectsPage = new ProjectsPage(driver);

        loginStep.successLogin(DataHelper.getUser());
    }



    }
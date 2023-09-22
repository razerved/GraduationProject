package tests.gui;

import base.BaseTest;
import configuration.ReadProperties;
import dataHelper.DataHelper;
import dataHelper.StaticProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Input;


public class ProjectTest extends BaseTest {


    @Test(description = "Кейс Авторизация")
    @Description("Positive login test")
    public void test1() {
        Assert.assertTrue(loginStep.successLogin(DataHelper.getUser()).isPageOpened());

    }


    @Test(description = "Проверка создания скрина")
    @Description("Negative login test")
    @Issue("BUG-3321")
    public void test2() {
        loginStep.negativeLogin("somePeople", ReadProperties.password());
        Assert.assertFalse(loginStep.errorText().equals("The email must be a valid email address."));
    }


    @Test(dataProvider = "Check summary", dataProviderClass = StaticProvider.class,
            description = "Проверка поля на граничные значения")
    public void test(String actualSummary, String expectedSummary) {

        loginStep.successLogin(DataHelper.getUser());
        projectsStep.setSummaryText(actualSummary);

        String summary = projectsStep.getSummaryInputDialog();

        Assert.assertTrue(summary.equals(expectedSummary), "кол-во введенных символов различается");
    }

    @Test(description = "Проверка возможности создания проекта")
    public void checkCreateNewProject() {

        loginStep.successLogin(DataHelper.getUser());
        boolean isCreated = projectsStep.createNewProject("first");
        Assert.assertTrue(isCreated);
    }

    @Test(description = "Проверка невозможности создания проекта с пустым названием")
    @Description("Negative create project")
    public void checkCreateNewProjectNegative(){
        loginStep.successLogin(DataHelper.getUser());
        boolean isDisplayed = projectsStep.createNewProjectNegative("     ");
        Assert.assertTrue(isDisplayed);
    }


//    @Test(description = "Проверка возможности удаления проекта")
//    public void checkDeleteProject() {
//
//        loginStep.successLogin(DataHelper.getUser());
//        projectsStep.createNewProject("second");
//        boolean isDeleted = projectsStep.deleteProject("second");
//        Assert.assertTrue(isDeleted);

//    @Test(description = "Проверка возможности удаления проекта")
//    public void checkDeleteProject() {
//        loginStep.successLogin(DataHelper.getUser());
//        var project = projectsStep.createNewProject("second");
//        var projectId = projectsStep.deleteProject(project, nameProject);
//        var deleteIcon = projectsStep.projectsPage.findProjectDeletionProcess(projectId);
//        Assert.assertTrue(deleteIcon != null);
//    }
}
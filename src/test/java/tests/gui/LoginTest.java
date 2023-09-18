package tests.gui;

import base.BaseTest;
import configuration.ReadProperties;
import dataHelper.DataHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.Test;


//ToDo изменить название LoginTest на общие Тесты
public class LoginTest extends BaseTest {


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


    //ToDo: Подумать над тестами на Граничные (желательно использовать Параметризированный тест )
    @Test(description = "Проверка поля на граничные значения 80")
    public void test3() {
        var actualSummary = "11111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111";

        loginStep.successLogin(DataHelper.getUser());
        projectsStep.setSummaryText(actualSummary);

        String expectedSummary = projectsStep.getSummaryInputDialog();

        Assert.assertTrue(actualSummary.equals(expectedSummary), "кол-во введенных символов различается");
    }

    @Test(description = "Проверка поля на граничные значения 80 + 1")
    public void test4() {
        var actualSummary = "11111111111111111111111111111111111111111" +
                "1111111111111111111111111111111111111112";

        loginStep.successLogin(DataHelper.getUser());
        projectsStep.setSummaryText(actualSummary);

        String expectedSummary = projectsStep.getSummaryInputDialog();

        Assert.assertFalse(actualSummary.equals(expectedSummary), "кол-во введенных символов различается");
    }

    @Test(description = "Проверка поля на граничные значения 0")
    public void test5() {
        var actualSummary = "";

        loginStep.successLogin(DataHelper.getUser());
        projectsStep.setSummaryText(actualSummary);

        String expectedSummary = projectsStep.getSummaryInputDialog();

        Assert.assertTrue(expectedSummary.equals(""), "кол-во введенных символов различается");
    }



    //ToDo: Дописать тесты на Создание и Удаление "Проекта"
    @Test(description = "Добавление нового Проекта")
    public void test6() {

        loginStep.successLogin(DataHelper.getUser());
        projectsStep.addNewProjectWhitOutSummary("OurNewProject");


    }

    @Test(description = "Удаление нового Проекта")
    public void test7() {

        loginStep.successLogin(DataHelper.getUser());
        projectsStep.addNewProjectWhitOutSummary("OurNewProject");


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
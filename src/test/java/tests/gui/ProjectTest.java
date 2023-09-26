package tests.gui;

import base.BaseTest;
import dataHelper.StaticProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProjectTest extends BaseTest {
    private static final String fileName = "anime-art-210822-1-576x1024.jpg";

    private String initFilePath() {
        String pathToFile = ProjectTest.class.getClassLoader().getResource(fileName).getPath();
        return pathToFile.substring(1, pathToFile.length());
    }


    @Test(dataProvider = "Check summary", dataProviderClass = StaticProvider.class,
            description = "Проверка поля на граничные значения", threadPoolSize = 3)
    public void checkBoundaryValues(String actualSummary, String expectedSummary) {
        projectsStep.setSummaryText(actualSummary);

        String summary = projectsStep.getSummaryInputDialog();

        Assert.assertTrue(summary.equals(expectedSummary), "кол-во введенных символов различается");
    }


    @Test(description = "Проверка возможности создания проекта")
    public void checkCreateNewProject() {

        boolean isCreated = projectsStep.createNewProject("first");
        Assert.assertTrue(isCreated);
    }


    @Test(description = "Проверка невозможности создания проекта с пустым названием")
    @Description("Negative create project")
    public void checkCreateNewProjectNegative() {
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

    @Test(description = "Проверка возможности удаления проекта")
    public void checkDeleteProject() {
        String nameProject = "second";
        var project = projectsStep.createNewProject(nameProject);
       // var projectId = projectsStep.deleteProject(nameProject);
//        Assert.assertTrue(deleteIcon != null);

    }

    @Test(description = "Тест на загрузку файла")
    public void checkUploadFileTest() {
        projectsStep.openAddProjectDialogWindow();
        projectsStep.uploadImage(initFilePath());
        Assert.assertTrue(projectsStep.checkSuccessUpload());
    }

    @Test(description = "Проверка отображения всплывающего меню при нажатии/наведении")
    public void checkViewPopUpMenu() {
        Assert.assertTrue(projectsStep.checkOpenPopUpMenu());
    }

    @Test(description = "в тесте идет удаление первого из списка проектов с проверкой на последующие вхождение удаленного по имени")
    public void newDelete(){
        Assert.assertTrue(projectsStep.newDeleteProject(), "Проект с таким именем есть в списке");
    }
}
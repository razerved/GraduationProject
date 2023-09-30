package tests.gui;

import base.BaseTest;
import dataHelper.StaticProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("All UI TESTS")
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
        Project project = new Project.Builder()
                .withName("first")
                .withSummary("some text in the field")
                .build();
        Assert.assertTrue(projectsStep.createNewProject("first"),"some text in the field");
    }


    @Test(description = "Проверка невозможности создания проекта с пустым названием")
    @Description("Negative create project")
    public void checkCreateNewProjectNegative() {
        boolean isDisplayed = projectsStep.createNewProjectNegative("     ");
        Assert.assertTrue(isDisplayed);
    }


@Test(description = "Проверка на загрузку файла")
public void checkUploadFileTest(){
    projectsStep.openAddProjectDialogWindow();
    projectsStep.uploadImage(initFilePath());
    Assert.assertTrue(projectsStep.checkSuccessUpload());
}

    @Test(description = "Проверка отображения всплывающего меню при нажатии/наведении")
    public void checkViewPopUpMenu() {
        Assert.assertTrue(projectsStep.checkOpenPopUpMenu());
    }

    @Test(description = "Проверка удаления первого в списке проекта")
    public void newDelete(){
        Assert.assertFalse(projectsStep.newDeleteProject(), "Проект с таким именем есть в списке");
    }
}
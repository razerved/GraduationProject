package tests.gui;

import base.BaseTest;
import dataHelper.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ProjectTest extends BaseTest {


    @Test(dataProvider = "Check summary", dataProviderClass = StaticProvider.class,
            description = "Проверка поля на граничные значения")
    public void checkBoundaryValues(String actualSummary, String expectedSummary) {
        projectsStep.setSummaryText(actualSummary);

        String summary = projectsStep.getSummaryInputDialog();

        Assert.assertTrue(summary.equals(expectedSummary), "кол-во введенных символов различается");
    }

    @Test(description = "Проверка отображения всплывающего меню при нажатии/наведении")
    public void checkViewPopUpMenu() {
        Assert.assertTrue(projectsStep.checkOpenPopUpMenu());
    }

}
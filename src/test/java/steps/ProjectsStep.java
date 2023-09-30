package steps;

import base.BaseStep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class ProjectsStep extends BaseStep {
    Logger logger = LogManager.getLogger(LoginPage.class);

    public ProjectsStep(WebDriver driver) {
        super(driver);
    }


    public String getSummaryInputDialog() {
        return (String) js.executeScript("return document.getElementsByTagName('textarea')[0].value");
    }

    public void setSummaryText(String summary) {
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.summaryInput().sendKeys(summary);
        logger.info("send summary: " + summary);
    }

    public boolean createNewProject(String nameProject) {
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.waitProjectDialogWindow().sendKeys(nameProject);
        projectsPage.submitButton().click();
        return projectsPage.getCreateProject().isDisplayed();

    }

    public boolean checkOpenPopUpMenu() {
        projectsPage.getPersonProfileSettings().click();
        return projectsPage.getPopUpLinkMenu().isDisplayed();
    }

    public boolean createNewProjectNegative(String nameProject) {
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.waitProjectDialogWindow().sendKeys(nameProject);
        projectsPage.submitButton().click();
        return projectsPage.getEmptyProjectNameLocator().isDisplayed();

    }

    public void openAddProjectDialogWindow() {
        projectsPage.addProjectClick();
    }

    public void uploadImage(String pathToFile) {
        projectsPage.getUploadImageWindow().click();
        projectsPage.getFileUpload().sendKeys(pathToFile);
    }

    public boolean checkSuccessUpload() {
        return projectsPage.checkSuccessUpload();
    }

    public boolean newDeleteProject() {
        projectsPage.getAdminButton().click();
        projectsPage.getProjectPanel().get(0).click();
        String nameProjectDelete = projectsPage.getNameOfProjects().get(0).getText();
        logger.info("name of delete project is: " + nameProjectDelete);

        projectsPage.getDeleteProgetByIndex().get(0).click();
        projectsPage.clickCheckBox().selectClickCheckBox();
        projectsPage.confirmDeleteProjectButton().click();
        boolean haveOrNot = projectsPage.getNameOfProjects().stream().filter(x->x.getText().equals(nameProjectDelete)).findAny().isPresent();
        return haveOrNot;

    }


}
package steps;

import base.BaseStep;

import elements.DialogBorder;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

public class ProjectsStep extends BaseStep {

    public ProjectsStep(WebDriver driver) {
        super(driver);
    }


    public void choseProject(int project){
        projectsPage.getBoardAllProjects().get(project).click();
    }


    public String getSummaryInputDialog(){
        return (String) js.executeScript("return document.getElementsByTagName('textarea')[0].value");
    }

    public void setSummaryText(String summary){
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.summaryInput().sendKeys(summary);
    }
    public void addNewProjectWhitSummary(String nameProject, String summary){
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.setNameProject().sendKeys(nameProject);
        projectsPage.summaryInput().sendKeys(summary);
    }

    public void addNewProjectWhitOutSummary(String nameProject){
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.setNameProject().sendKeys(nameProject);
        projectsPage.getBorderAddProjectLButton().click();

    }

    public boolean createNewProject(String nameProject) {
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.waitProjectDialogWindow().sendKeys(nameProject);
        projectsPage.submitButton().click();
        return projectsPage.getCreateProject().isDisplayed();

    }
    public boolean checkOpenPopUpMenu(){
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

//    public boolean deleteProject(String nameProject) {
//        projectsPage.getAddProject().click();
//        projectsPage.waitProjectDialogWindow().isDisplayed();
//        projectsPage.waitProjectDialogWindow().sendKeys(nameProject);
//        projectsPage.submitButton().click();
//        projectsPage.deleteIcon().click();
//        projectsPage.deleteProjectModalWindow().isDisplayed();
//        projectsPage.deleteCheckBox().click();
//        projectsPage.confirmDeleteProjectButton().click();
//        return projectsPage.projectDeletionProcess().isDisplayed();

    public String deleteProject(Project project, String nameProject) {
        projectsPage.getAddProject().click();
        projectsPage.waitProjectDialogWindow().isDisplayed();
        projectsPage.waitProjectDialogWindow().sendKeys(nameProject);
        projectsPage.submitButton().click();
        var tableRow = projectsPage.getTableRowProjectName(project.getName());
        var projectId = tableRow.getAttribute("data-id");
        var deleteIcon = tableRow.findElement((By) projectsPage.deleteIcon());
        deleteIcon.click();

        projectsPage.deleteCheckBox().click();
        projectsPage.confirmDeleteProjectButton().click();

        return projectId;

    }
    public void openAddProjectDialogWindow() {
        projectsPage.addProjectClick();
    }
    public boolean checkSuccessUpload() {
        return projectsPage.getProjectImage().getAttribute("src").contains("attachments");
    }

    public void uploadImage(String pathToFile) {
        projectsPage.getUploadImageWindow().click();
        projectsPage.getFileUpload().sendKeys(pathToFile);
    }

    public void initProjectFields(Project project) {
        projectsPage.getProjectNameLocator().sendKeys(project.getName());
        uploadImage(project.getImagePath());
        projectsPage.getBorderAddProjectLButton().click();
    }
    public ProjectsPage createProject(Project project){
        initProjectFields(project);
        return projectsPage;
    }

}
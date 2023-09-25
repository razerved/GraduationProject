package steps;

import base.BaseStep;

import org.openqa.selenium.WebDriver;

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

    public boolean checkOpenPopUpMenu(){
        projectsPage.getPersonProfileSettings().click();
        return projectsPage.getPopUpLinkMenu().isDisplayed();
    }


}
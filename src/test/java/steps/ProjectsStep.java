package steps;

import base.BaseStep;
import elements.DialogBorder;
import org.openqa.selenium.WebDriver;

public class ProjectsStep extends BaseStep {

    public ProjectsStep(WebDriver driver) {
        super(driver);
    }


    public void choseProject(int project){
        projectsPage.getBoardAllProjects().get(project).click();
    }
    public DialogBorder dialogBorderCheckout(){
        projectsPage.getDialogBorder();
        return dialogBorderCheckout();
    }




}

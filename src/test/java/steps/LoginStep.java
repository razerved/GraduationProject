package steps;

import base.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginStep extends BaseStep {


    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage successLogin(String email, String password){
        loginPage.login(email, password);
        return projectsPage;
    }

    public LoginPage negativeLogin(String email, String password){
        loginPage.login(email, password);
        return loginPage;
    }
    public String errorText(){
        return loginPage.getErrorText().getText();
    }


}

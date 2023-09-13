package steps;

import base.BaseStep;
import models.Users;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginStep extends BaseStep {


    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage successLogin(Users users){
        loginPage.login(users);
        return projectsPage;
    }

    public LoginPage negativeLogin(String email, String password){
        loginPage.loginNegative(email, password);
        return loginPage;
    }
    public String errorText(){
        return loginPage.getErrorText().getText();
    }


}

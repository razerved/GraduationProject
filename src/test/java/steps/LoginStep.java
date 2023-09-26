package steps;

import base.BaseStep;
import models.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginStep extends BaseStep {
    Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage successLogin(Users users) {
        loginPage.login(users);
        logger.info("Use method successLogin" + users);
        return projectsPage;
    }

    public LoginPage negativeLogin(String email, String password){
        loginPage.loginNegative(email, password);
        logger.info("Use method successLogin" + email + " " +password);
        return loginPage;
    }
    public String errorText(){
        return loginPage.getErrorText().getText();
    }


}

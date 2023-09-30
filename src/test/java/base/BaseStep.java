package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

public class BaseStep {

    protected WebDriver driver;
    protected LoginPage loginPage;
    public ProjectsPage projectsPage;
    protected JavascriptExecutor js;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        js = (JavascriptExecutor) driver;

    }


}

package base;

import configuration.ReadProperties;
import dataHelper.DataHelper;
import factory.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginStep;
import steps.ProjectsStep;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected ProjectsStep projectsStep;
    protected JavascriptExecutor js;


    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        this.setDriverToContext(iTestContext, driver);

        loginStep = new LoginStep(driver);
        projectsStep = new ProjectsStep(driver);
        js = (JavascriptExecutor) driver;

        driver.get(ReadProperties.getUrl());

        loginStep.successLogin(DataHelper.getUser());
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver){
        iTestContext.setAttribute("WebDriver", driver);
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            System.out.println("Make screenshot");
        }
        driver.quit();
    }

}

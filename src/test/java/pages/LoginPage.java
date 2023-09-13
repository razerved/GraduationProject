package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final static String pagePath = "/auth/login";
    private final By emailInputLocator = By.name("email");
    private final By passwordInputLocator = By.name("password");
    private final By loginButtonLocator = By.cssSelector("button.ui.primary.button");
    private final By checkBoxInputLocator = By.name("remember");
    private final By forgotButtonLocator = By.cssSelector("a.ui.button");
    private final By errorTextLocator = By.cssSelector("div.message-block--scroll");



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }


    public WebElement getEmail(){
        return driver.findElement(emailInputLocator);
    }
    public WebElement getPassword(){
        return driver.findElement(passwordInputLocator);
    }
    public WebElement getLoginButton(){
        return driver.findElement(loginButtonLocator);
    }
    public WebElement getCheckBox(){
        return driver.findElement(checkBoxInputLocator);
    }
    public WebElement getForgotButton(){
        return  driver.findElement(forgotButtonLocator);
    }
    public WebElement getErrorText(){
        return driver.findElement(errorTextLocator);
    }


    public void setCheckBox(){
        getCheckBox().click();
    }


    public void login(String email, String password){
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginButton().click();
    }


}

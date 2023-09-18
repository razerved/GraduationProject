package pages;

import base.BasePage;
import elements.DialogBorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectsPage extends BasePage {
    private final static String pagePath ="yaninalondon.testmo.net";
    private final By addProjectLocator = By.cssSelector(".ui.basic.compact.button");
    private final By boardAllProjectsLocator = By.cssSelector("tr div a");
    private final By logoLocator = By.cssSelector(".navbar__branding__logo");
    private final By dialogBorderLocator = By.cssSelector("div.dialog__border");

    private final By borderDialogInputNameLocator = By.cssSelector("div.field.required input");
    private final By borderDialogInputTextLocator = By.cssSelector("div.maxlength-counter textarea");
    private final By borderDropDownLocator = By.cssSelector("div.dropdown__content");
    private final By borderPopupLocator = By.cssSelector("div.popup__border div.dropdown__items__row");
    private final By borderCheckBoxLocator = By.cssSelector("input[type='checkbox']");
    private final By borderButtonSelectAvatarLocator = By.cssSelector("button.fluid.button");
    private final By borderAddProjectLocator = By.cssSelector("button.ui.button.primary");
    private final By borderCancelProjectLocator = By.cssSelector("button.ui.button.dialog-hide");
    private final By borderInputFileLocator = By.xpath("//input[@type='file']");
    private elements.DialogBorder DialogBorder;


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return null;
    }


    public WebElement getAddProject(){
        return driver.findElement(addProjectLocator);
    }
    public List<WebElement> getBoardAllProjects(){
        return driver.findElements(boardAllProjectsLocator);
    }
    public WebElement getLogo(){
        return driver.findElement(logoLocator);
    }

    public DialogBorder getDialogBorder(){
        return new DialogBorder(driver, dialogBorderLocator);
    }
    public WebElement summaryInput()
    {
        return driver.findElement(borderDialogInputTextLocator);
    }

    /**
     * textarea - специфичен, знаю только, что можно вытащить с помощью JS ( ИМХО )
     * @return
     */
    /*public String SummaryInputDialog()
    {
        return driver.findElement(borderDialogInputTextLocator).getAttribute("value");
    }*/

    public WebElement waitProjectDialogWindow(){
        return waitService.waitForExists(borderDialogInputNameLocator);
    }

    public WebElement setNameProject(){
        return  driver.findElement(borderDialogInputNameLocator);
    }

    public WebElement getDropDownMenu(){
        return driver.findElement(borderDropDownLocator);
    }


}
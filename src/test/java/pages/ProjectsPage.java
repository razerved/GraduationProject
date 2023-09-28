package pages;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.Button;
import wrappers.CheckBox;

import java.time.Duration;
import java.util.List;

public class ProjectsPage extends BasePage {
    private final static String pagePath ="/admin/projects";
    private final By addProjectLocator = By.cssSelector(".ui.basic.compact.button");
    private final By borderDialogInputNameLocator = By.cssSelector("div.field.required input");
    private final By borderDialogInputTextLocator = By.cssSelector("div.maxlength-counter textarea");
    private final By borderAddProjectLocator = By.cssSelector("button.ui.button.primary");
    private final By createProjectLocator = By.cssSelector("div.page-header__title");
    private final By deleteCheckboxLocator = By.xpath("//label[@data-target='confirmationLabel']");
    private final By confirmDeleteProjectButtonLocator = By.xpath(("//button[@data-target='deleteButton']"));
    private final By emptyProjectNameLocator = By.xpath("//li[text()='The name field is required.']");
    private final By uploadImageWindowLocator = By.xpath("//*[@class='admin-projects-dialog-avatar__action']");
    private final By projectImageLocator = By.xpath("//*[@class='admin-projects-dialog-avatar__avatar']/descendant::img");
    private final By fileUploadLocator = By.xpath("//input[@type='file']");
    private final By addProjectButtonLocator = By.xpath("//*[@class='ui basic compact button']");

    private final By personProfileSettingsLocator = By.cssSelector("div.avatar.avatar--person.avatar--32");
    private final By popUpMenuLinkLocator = By.cssSelector("a.popup__menu__link-item");

    private final By adminButtonLocator = By.cssSelector("a[data-content='Admin']");
    private final By projectPanelLocator = By.cssSelector("a[href|='https://yaninalondon.testmo.net/admin/projects']");
    private final By deleteProjectLocator = By.cssSelector("tr.table__header ~ tr > td> div.tooltip");

    private final By nameOfProjects = By.cssSelector("a[data-action='edit']");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("div.page-title__title");
    }


    public WebElement getAddProject() {
        return waitService.waitForExists(addProjectLocator);
    }


    public WebElement summaryInput() {
        return driver.findElement(borderDialogInputTextLocator);
    }

    public WebElement waitProjectDialogWindow() {
        return waitService.waitForExists(borderDialogInputNameLocator);
    }

    public WebElement submitButton() {
        return driver.findElement(borderAddProjectLocator);
    }

    public WebElement getCreateProject() {
        return waitService.waitForExists(createProjectLocator);
    }


    public CheckBox clickCheckBox() {
        return new CheckBox(driver, deleteCheckboxLocator);
    }

    public Button confirmDeleteProjectButton() {
        return new Button(driver, confirmDeleteProjectButtonLocator);
    }


    public WebElement getEmptyProjectNameLocator() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyProjectNameLocator));
        return driver.findElement(emptyProjectNameLocator);
    }

    public WebElement getUploadImageWindow() {
        return waitService.waitForExists(uploadImageWindowLocator);
    }

    public WebElement getProjectImage() {
        return waitService.waitForExists(projectImageLocator);
    }

    public WebElement getFileUpload() {
        return waitService.waitForExists(fileUploadLocator);
    }

    public void addProjectClick() {
        getAddProjectButtonLocator().click();
    }
    public WebElement getAddProjectButtonLocator(){
        return waitService.waitForExists(addProjectButtonLocator);
    }


    public WebElement getPersonProfileSettings(){
        return driver.findElement(personProfileSettingsLocator);
    }

    public WebElement getPopUpLinkMenu(){
        return driver.findElement(popUpMenuLinkLocator);
    }


    public List<WebElement> getProjectPanel(){
        return waitService.waitForAllVisibleElementsLocatedBy(projectPanelLocator);
    }
    public WebElement getAdminButton(){
        return driver.findElement(adminButtonLocator);
    }

    public List<WebElement> getDeleteProgetByIndex(){
        return waitService.waitForAllVisibleElementsLocatedBy(deleteProjectLocator);
    }

    public List<WebElement> getNameOfProjects(){
        return waitService.waitForAllVisibleElementsLocatedBy(nameOfProjects);
    }
    public boolean checkSuccessUpload() {
        getProjectImage().getAttribute("src").contains("attachment");
        return true;
    }
}
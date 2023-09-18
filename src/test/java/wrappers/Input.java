package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input {
    private UIElement uiElement;

    public Input(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public Input(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public void sendKeys(CharSequence... keysToSend) {
        uiElement.sendKeys(keysToSend);
    }

    public void clearAndSendKeys(CharSequence... keysToSend) {
        uiElement.clear();
        sendKeys(keysToSend);
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }
}

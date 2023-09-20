package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void set() {
        setFlag(true);
    }

    public void remove() {
        setFlag(false);
    }

    public void setFlag(boolean flag) {
        if (!isSelected() && flag) {
            uiElement.click();
        }
    }

    public boolean isSelected() {
        return uiElement.isSelected();
    }
}

package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDown {
    private WebDriver driver;
    private By by = null;
    private WebElement webElement;
    private List<WebElement> numberList = new ArrayList<>();
    private List<String> textList = new ArrayList<>();

    public DropDown(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        this.webElement = webElement;
        textList.add(webElement.findElement(By.cssSelector("Добавить селектор на Дроп")).getText());
    }

    public DropDown(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.by = by;
        this.webElement = webElement;
    }


}
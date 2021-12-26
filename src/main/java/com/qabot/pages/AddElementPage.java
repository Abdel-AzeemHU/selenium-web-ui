package com.qabot.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.IntStream;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AddElementPage extends MasterPage {
    @FindBy(id="elements")
    private WebElement elementContainer;

    private final By header = By.tagName("h3");

    public AddElementPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify the right page loads")
    public boolean validatePage() {
        return driver.findElement(header).getText().equalsIgnoreCase("Add/Remove elements");
    }

    @Step("Click 'Add element' button to generate 'Delete' button instance")
    public void addElements(int n) {
        WebElement headerTitle = driver.findElement(header);
        WebElement btnAdd = driver.findElement(with(By.tagName("button")).below(headerTitle));
        IntStream.range(0, n).parallel().forEachOrdered(_x->clickButton(btnAdd));
    }

    @Step("Verify there are the {n} 'Delete' buttons")
    public boolean validateButtonCount(int n) {
        List<WebElement> btns = elementContainer.findElements(By.tagName("button"));
        System.out.println("Element Count: " + btns.size());
        return btns.size()==n;
    }

    @Step("Click each 'Delete' button to dismiss")
    public void dismissButtons() {
        List<WebElement> btns = elementContainer.findElements(By.tagName("button"));
        btns.stream().forEach(btn->clickButton(btn));
    }
}

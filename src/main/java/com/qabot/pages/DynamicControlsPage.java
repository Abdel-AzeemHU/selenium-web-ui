package com.qabot.pages;

import com.google.common.base.Function;
import com.qabot.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;

public class DynamicControlsPage extends MasterPage {
    @FindBy(tagName = "h4")
    private WebElement header;

    @FindBy(css = "#checkbox-example button")
    private WebElement btnRemove;

    @FindBy(id = "checkbox")
    private WebElement checkbox;

    @FindBy(css = "#checkbox-example #message")
    private WebElement checkboxMessage;

    @FindBy(css = "#input-example button")
    private WebElement btnEnable;

    @FindBy(css = "#input-example input")
    private WebElement txt;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get checkbox message")
    public String checkboxMessage() {
        return checkboxMessage.getText();
    }

    @Step("validate text input status")
    public boolean txtInputState() {
        return txt.isEnabled();
    }

    @Step("validate the right page")
    public boolean validatePage() {
        return header.getText().equalsIgnoreCase("Dynamic Controls");
    }

    @Step("Get the text of Add / Remove button")
    public String removeButtonText() {
        return btnRemove.getText();
    }

    @Step("Enable / disable button text")
    public String buttonEnabledText() {
        return btnEnable.getText();
    }

    @Step("Click remove button to hide the checkbox")
    public void removeCheckbox() {
        clickButton(btnRemove);
        WaitUtils.waitForCondition(driver, ExpectedConditions.invisibilityOf(checkbox), 20);
    }

    @Step("Click Add button to show checkbox")
    public void addCheckbox() {
        clickButton(btnRemove);
        WaitUtils.waitForCondition(driver, ExpectedConditions.visibilityOf(checkbox), 20);
    }

    @Step("Click enable")
    public WebElement enableText() {
        clickButton(btnEnable);
        return WaitUtils.waitForCustomCondition(driver, new Function<WebDriver, WebElement>() {
                    public @Nullable
                    WebElement apply(WebDriver d) {
                        WebElement element = d.findElement(By.cssSelector("#input-example #message"));
                        return element.isDisplayed() ? element : null;
                    }
                }
                , 20);
    }
}

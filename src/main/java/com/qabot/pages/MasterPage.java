package com.qabot.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MasterPage {
    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected Select select;
    protected Actions action;

    public MasterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
    }

    protected void clickButton(WebElement button)
    {
        button.click();
    }

    protected void setTextElementText(WebElement textElement , String value)
    {
        textElement.sendKeys(value);
    }

    protected void scrollToBottom()
    {
        jse.executeScript("scrollTo(0, document.body.scrollHeight)");
    }

    protected void clearText(WebElement element)
    {
        element.clear();
    }
}

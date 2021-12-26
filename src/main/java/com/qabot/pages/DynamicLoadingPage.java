package com.qabot.pages;

import com.qabot.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DynamicLoadingPage extends MasterPage {
    @FindBy(tagName = "h3")
    private WebElement header;

    @FindBy(css = "div.example a")
    private List<WebElement> links;

    InnerPage inner;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
        inner = new InnerPage(driver);
    }

    @Step("validate the right page")
    public boolean validatePage() {
        return header.getText().equalsIgnoreCase("Dynamically Loaded Page Elements");
    }

    @Step("Click Example with index {index}")
    public void openExampleByIndex(int index) {
        clickButton(links.get(index));
    }

    @Step("Get Section Header")
    public String subHeader() {
        return inner.header();
    }

    @Step("Get hidden text")
    public String hiddenContent() {
        return inner.getHiddenText();
    }

    private class InnerPage extends MasterPage{
        @FindBy(tagName = "h4")
        private WebElement subHeader;

        @FindBy(tagName = "button")
        private WebElement btnStart;

        @FindBy(css = "#finish h4")
        private WebElement txtHello;

        public InnerPage(WebDriver driver) {
            super(driver);
        }

        @Step("Get sub header")
        private String header() { return subHeader.getText();}

        @Step("Click 'Start' button")
        private String getHiddenText() {
            clickButton(btnStart);
            WaitUtils.waitVisibilityOf(driver, txtHello, 20);
            System.out.println("Hidden Content: " + txtHello.getText());
            return txtHello.getText();
        }
    }
}



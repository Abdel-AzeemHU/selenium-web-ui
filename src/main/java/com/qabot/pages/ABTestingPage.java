package com.qabot.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABTestingPage extends MasterPage{

    public ABTestingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div[class='example'] h3")
    private WebElement abTestingHeaderTxt;

    @FindBy(css = "div[class='example'] p")
    private WebElement abTestingContentTxt;

    @Step("Get the AB testing page header text")
    public String getABHeaderText() {
        return abTestingHeaderTxt.getText();
    }

    @Step("Get the AB testing page content text")
    public String getABContentText() {
        return abTestingContentTxt.getText();
    }

    @Step("Verify the AB testing page header text")
    public String checkABHeaderText() {
        return abTestingHeaderTxt.getText();
    }

    @Step("Verify the AB testing page content text")
    public boolean checkABContentText() {
        return abTestingContentTxt.getText().contains("Also known as split testing");
    }
}

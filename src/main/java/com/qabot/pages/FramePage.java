package com.qabot.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends MasterPage {
    @FindBy(tagName = "h3")
    private WebElement header;

    @FindBy(css = "ul a")
    private List<WebElement> links;

    private IFramePage iFramePage;

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate the right page")
    public boolean validatePage() {
        return header.getText().equalsIgnoreCase("frames");
    }

    @Step("Click iFrame link")
    public IFramePage openIFramePage() {
        clickButton(links.get(1));
        return new IFramePage(driver);
    }
}

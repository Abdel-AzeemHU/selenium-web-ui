package com.qabot.pages;

import com.qabot.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryAdPage extends MasterPage {

    public EntryAdPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='modal']")
    private WebElement popup;

    @FindBy(css = "div[class='modal-title'] h3")
    private WebElement popupHeaderTxt;

    @FindBy(css = "div[class='modal-body'] p")
    private WebElement popupBodyTxt;

    @FindBy(css = "div[class='modal-footer'] p")
    private WebElement closeBtn;

    public String getTheHeaderText() {
        return popupHeaderTxt.getText();
    }

    @Step("Get the popup header text")
    public boolean getPopupHeaderText() {
        WaitUtils.waitVisibilityOf(driver, popup, 5);
        return popupHeaderTxt.getText().equalsIgnoreCase("THIS IS A MODAL WINDOW");
    }

    @Step("Get the popup body text")
    public boolean getPopupBodyText() {
        return popupBodyTxt.getText().contains("It's commonly used to encourage a user to take an action");
    }

    @Step("Close the popup")
    public void closeThePopup() {
        clickButton(closeBtn);
    }
}

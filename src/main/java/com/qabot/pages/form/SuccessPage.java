package com.qabot.pages.form;

import com.qabot.pages.LoginPage;
import com.qabot.pages.MasterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends MasterPage implements PostLoginPage {
    @FindBy(tagName = "h2")
    private WebElement secureArea;

    @FindBy(linkText = "Logout")
    private WebElement btnLogout;

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getStatus() {
        return secureArea.getText();
    }

    public LoginPage backToLogin() {
        clickButton(btnLogout);
        return new LoginPage(driver);
    }
}

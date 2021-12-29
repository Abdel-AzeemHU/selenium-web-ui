package com.qabot.pages.form;

import com.qabot.pages.LoginPage;
import com.qabot.pages.MasterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FailurePage extends MasterPage implements PostLoginPage {
    @FindBy(id = "flash")
    private WebElement flash;

    public FailurePage(WebDriver driver) {
        super(driver);
    }

    public String getStatus() {
        return flash.getText().replace("x", "").trim();
    }

    public LoginPage backToLogin() {
        return new LoginPage(driver);
    }
}

package com.qabot.pages;

import com.qabot.pages.form.FailurePage;
import com.qabot.pages.form.PostLoginPage;
import com.qabot.pages.form.SuccessPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LoginPage extends MasterPage {
    @FindBy(tagName = "h2")
    private WebElement header;

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(css = "button[type=submit]")
    private WebElement btnLogin;

    private final Map<Boolean, PostLoginPage> loginTypes = new HashMap<>();

    public LoginPage(WebDriver driver) {
        super(driver);
        loginTypes.put(true, new SuccessPage(driver));
        loginTypes.put(false, new FailurePage(driver));
    }

    @Step("validate the right page")
    public boolean validatePage() {
        return header.getText().equalsIgnoreCase("login page");
    }

    public PostLoginPage doLogin(String username, String password, boolean success) {
        setTextElementText(txtUsername, username);
        setTextElementText(txtPassword, password);
        clickButton(btnLogin);
        return this.loginTypes.get(success);
    }
}

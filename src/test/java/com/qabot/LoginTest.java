package com.qabot;

import com.qabot.pages.LoginPage;
import com.qabot.pages.form.PostLoginPage;
import org.testng.annotations.Test;

public class LoginTest extends MasterTest {
    LoginPage loginPage;

    @Test(priority = 1, description = "Success login")
    void testLoginSuccess() {
        loginPage = homePage.clickLinkByText("Form Authentication", LoginPage.class);
        softAssert.assertTrue(loginPage.validatePage());

        PostLoginPage postLoginPage = loginPage.doLogin("tomsmith", "SuperSecretPassword!", true);
        softAssert.assertEquals(postLoginPage.getStatus(), "Secure Area");
        loginPage = postLoginPage.backToLogin();
        softAssert.assertTrue(loginPage.validatePage());

        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Invalid login")
    void testLoginFailure() {
        PostLoginPage postLoginPage = loginPage.doLogin("notfound", "invalid-password", false);
        softAssert.assertEquals(postLoginPage.getStatus(), "Your username is invalid!\n×");
        loginPage = postLoginPage.backToLogin();
        softAssert.assertTrue(loginPage.validatePage());

        softAssert.assertAll();
    }
}

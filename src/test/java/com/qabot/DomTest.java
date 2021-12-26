package com.qabot;

import com.qabot.pages.ChallengingDOMPage;
import org.testng.annotations.Test;

public class DomTest extends MasterTest {
    ChallengingDOMPage challengingDOMPage;

    @Test(priority = 1, description = "validate the right page")
    void validatePage() {
        challengingDOMPage = homePage.clickLinkByText("Challenging DOM", ChallengingDOMPage.class);
        softAssert.assertTrue(challengingDOMPage.validatePage());
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "validate column header")
    void validateColumnHeader() {
        softAssert.assertEquals(challengingDOMPage.validateColumn(0), 10);
        softAssert.assertAll();
    }
}

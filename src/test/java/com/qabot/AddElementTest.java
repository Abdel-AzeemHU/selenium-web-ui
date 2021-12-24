package com.qabot;

import com.qabot.pages.AddElementPage;
import com.qabot.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddElementTest extends MasterTest {
    @Test(description = "Click add element (n) times and then dismiss all 'Delete' buttons")
    void testAddRemoveElements() {
        HomePage homePage = new HomePage(driver);
        AddElementPage elementPage = homePage.clickLinkByText("Add/Remove Elements", AddElementPage.class);
        softAssert.assertTrue(elementPage.validatePage());
        elementPage.addElements(3);
        softAssert.assertTrue(elementPage.validateButtonCount(3));

        elementPage.dismissButtons();
        softAssert.assertTrue(elementPage.validateButtonCount(0));
        softAssert.assertAll();
    }
}

package com.qabot;

import com.qabot.pages.BrokenImagePage;
import org.testng.annotations.Test;

public class BrokenImageTest extends MasterTest {
    BrokenImagePage brokenImagePage;

    @Test(description = "Find images with broken links", priority = 1)
    void testPageHeader() {
        brokenImagePage = homePage.clickLinkByText("Broken Images", BrokenImagePage.class);
        softAssert.assertTrue(brokenImagePage.validatePage());
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Validate number of broken images (2)")
    void testBrokenImages() {
        softAssert.assertTrue(brokenImagePage.validateBrokenImages());
        softAssert.assertAll();
    }
}

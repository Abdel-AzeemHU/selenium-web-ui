package com.qabot;

import com.qabot.pages.DynamicLoadingPage;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends MasterTest {
    DynamicLoadingPage dynamicLoadingPage;

    @Test(priority = 1, description = "validate the page loads correctly")
    void testDynamicLoadedPage() {
        dynamicLoadingPage = homePage.clickLinkByText("Dynamic Loading", DynamicLoadingPage.class);
        softAssert.assertTrue(dynamicLoadingPage.validatePage());
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "validate the hidden content shows up with the right text")
    void testHiddenContent() {
        dynamicLoadingPage.openExampleByIndex(1);
        softAssert.assertEquals(dynamicLoadingPage.subHeader(), "Example 2: Element rendered after the fact");
        softAssert.assertEquals(dynamicLoadingPage.hiddenContent(), "Hello World!");
        softAssert.assertAll();
    }
}

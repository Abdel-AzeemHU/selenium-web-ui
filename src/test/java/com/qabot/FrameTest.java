package com.qabot;

import com.qabot.pages.FramePage;
import com.qabot.pages.IFramePage;
import com.qabot.utils.DataFaker;
import org.testng.annotations.Test;

public class FrameTest extends MasterTest {
    FramePage framePage;

    @Test(priority = 1, description = "Validate the page")
    void testFramePage() {
        framePage = homePage.clickLinkByText("Frames", FramePage.class);
        softAssert.assertTrue(framePage.validatePage());
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Test Frame sub page")
    void testSubPage() {
        DataFaker dataFaker = DataFaker.getInstance();
        String randomText = dataFaker.getRandom().lorem().sentence();

        IFramePage iFramePage = framePage.openIFramePage();
        softAssert.assertTrue(iFramePage.validatePage());

        String paragraph = iFramePage.typeText(randomText);

        softAssert.assertEquals(paragraph, randomText);
        softAssert.assertAll();
    }
}

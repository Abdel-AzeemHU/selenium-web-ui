package com.qabot;

import com.qabot.pages.DynamicControlsPage;
import org.testng.annotations.Test;

public class DynamicControlTest extends MasterTest {
    DynamicControlsPage dynamicControlsPage;

    @Test(priority = 1, description = "Hide the checkbox")
    void testRemoveCheckbox() {
        dynamicControlsPage = homePage.clickLinkByText("Dynamic Controls", DynamicControlsPage.class);
        softAssert.assertTrue(dynamicControlsPage.validatePage());
        dynamicControlsPage.removeCheckbox();
        softAssert.assertEquals(dynamicControlsPage.checkboxMessage(), "It's gone!");
        softAssert.assertEquals(dynamicControlsPage.removeButtonText(), "Add");

        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Show the checkbox")
    void testAddCheckbox() {
        dynamicControlsPage.addCheckbox();
        softAssert.assertEquals(dynamicControlsPage.checkboxMessage(), "It's back!");
        softAssert.assertEquals(dynamicControlsPage.removeButtonText(), "Remove");

        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Enable the text box")
    void testEnableText() {
        softAssert.assertEquals(dynamicControlsPage.enableText().getText(), "It's enabled!");
        softAssert.assertEquals(dynamicControlsPage.buttonEnabledText(), "Disable");
        softAssert.assertEquals(dynamicControlsPage.txtInputState(), true);

        softAssert.assertAll();
    }

    @Test(priority = 4, description = "Disable the text box")
    void testDisableText() {
        softAssert.assertEquals(dynamicControlsPage.enableText().getText(), "It's disabled!");
        softAssert.assertEquals(dynamicControlsPage.buttonEnabledText(), "Enable");
        softAssert.assertEquals(dynamicControlsPage.txtInputState(), false);

        softAssert.assertAll();
    }
}

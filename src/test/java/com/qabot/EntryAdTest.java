package com.qabot;

import com.qabot.pages.EntryAdPage;
import org.testng.annotations.Test;

public class EntryAdTest extends MasterTest{

    EntryAdPage entryAdPage;

    @Test(priority = 1, description = "Check the popup header and body text")
    public void checkThePopupAppearance() {
        entryAdPage = homePage.clickLinkByText("Entry Ad", EntryAdPage.class);
        softAssert.assertTrue(entryAdPage.getPopupHeaderText());
        softAssert.assertTrue(entryAdPage.getPopupBodyText());
        System.out.println("The context menu header is: " + entryAdPage.getTheHeaderText());
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Close the popup after verifying the header and body")
    public void closeThePopup() {
        entryAdPage.closeThePopup();
    }

}

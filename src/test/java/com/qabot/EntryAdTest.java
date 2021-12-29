package com.qabot;

import com.qabot.pages.EntryAdPage;
import org.testng.annotations.Test;

public class EntryAdTest extends MasterTest{

    EntryAdPage entryAdPage;

    @Test(description = "Check the popup header and body text")
    public void checkThePopupAppearance() {
        entryAdPage = homePage.clickLinkByText("Entry Ad", EntryAdPage.class);
        softAssert.assertTrue(entryAdPage.getPopupHeaderText());
        softAssert.assertTrue(entryAdPage.getPopupBodyText());
        System.out.println("The context menu header is: " + entryAdPage.popupHeaderTxt.getText());
        softAssert.assertAll();
    }

    @Test(description = "Close the popup after verifying the header and body")
    public void closeThePopup() {
        entryAdPage.closeThePopup();
    }

}

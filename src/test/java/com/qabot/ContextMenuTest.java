package com.qabot;

import com.qabot.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class  ContextMenuTest extends MasterTest{

    @Test(description = "Click context menu and perform the right click and accept the alert")
    public void performRightClickAndAcceptTheAlert() {
        ContextMenuPage contextMenuPage = homePage.clickLinkByText("Context Menu", ContextMenuPage.class);
        contextMenuPage.rightClickAndAcceptTheAlert();
        Assert.assertTrue(contextMenuPage.contextMenuHeaderTxt.getText().contains("Context Menu"));
        System.out.println("The context menu header is: " + contextMenuPage.contextMenuHeaderTxt.getText());

    }
}

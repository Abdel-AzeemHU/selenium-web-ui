package com.qabot;

import com.qabot.pages.CheckBoxesPage;
import com.qabot.pages.ContextMenuPage;
import com.qabot.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends MasterTest{

    @Test(description = "Click context menu  ")
    public void performRightClickAndAcceptTheAlert() {
        HomePage homePage = new HomePage(driver);
        ContextMenuPage contextMenuPage = homePage.clickLinkByText("Context Menu", ContextMenuPage.class);
        contextMenuPage.rightClickAndAcceptTheAlert();
        Assert.assertTrue(contextMenuPage.contextMenuHeaderTxt.getText().contains("Context Menu"));
        System.out.println("The context menu header is: " + contextMenuPage.contextMenuHeaderTxt.getText());

    }
}

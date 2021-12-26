package com.qabot;

import com.qabot.pages.CheckBoxesPage;
import com.qabot.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest extends MasterTest{

    @Test(description = "Click on Checkboxes and check the first one is unchecked and the second one is checked")
    public void checkTheFirstCheckboxUnselectedAndSecondCheckboxSelected() {

        HomePage homePage = new HomePage(driver);
        CheckBoxesPage checkBoxPage = homePage.clickLinkByText("Checkboxes", CheckBoxesPage.class);
        Assert.assertTrue(checkBoxPage.checkBoxesTitleTxt.getText().contains("Checkboxes"));
        Assert.assertFalse(checkBoxPage.checkBox1.isSelected());
        Assert.assertTrue(checkBoxPage.checkBox2.isSelected());
        System.out.println("The checkboxes title is: " + checkBoxPage.checkBoxesTitleTxt.getText());
    }

}

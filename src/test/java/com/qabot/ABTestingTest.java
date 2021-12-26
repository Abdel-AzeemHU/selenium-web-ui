package com.qabot;

import com.qabot.pages.ABTestingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABTestingTest extends MasterTest{

    @Test(description = "Click A/B Testing link and check the Header and Content")
    public void testABTestingContentAndHeader() {
        ABTestingPage abTestingPage = homePage.clickLinkByText("A/B Testing", ABTestingPage.class);
        Assert.assertTrue(abTestingPage.abTestingHeaderTxt.getText().contains("A/B Test Control"));
        Assert.assertTrue(abTestingPage.abTestingContentTxt.getText().contains("Also known as split testing"));
        System.out.println("The header is: "+ abTestingPage.abTestingHeaderTxt.getText() + " and the content is : " + abTestingPage.abTestingContentTxt.getText());
    }

}

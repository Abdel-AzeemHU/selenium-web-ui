package com.qabot;

import com.qabot.pages.ABTestingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABTestingTest extends MasterTest{

    @Test(description = "Click A/B Testing link and check the Header and Content")
    public void testABTestingContentAndHeader() {
        ABTestingPage abTestingPage = homePage.clickLinkByText("A/B Testing", ABTestingPage.class);
        softAssert.assertTrue(abTestingPage.checkABHeaderText().contains("A/B Test"));
        softAssert.assertTrue(abTestingPage.checkABContentText());
        System.out.println("The header is: "+ abTestingPage.getABHeaderText() + " and the content is : " + abTestingPage.getABContentText());
        softAssert.assertAll();
    }

}

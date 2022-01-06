package com.qabot;

import com.qabot.pages.SliderPage;
import org.testng.annotations.Test;

public class SliderTest extends MasterTest {
    SliderPage sliderPage;

    @Test(priority = 1, description = "Move the slider to a value")
    void testSlide() {
        String slides = "4.5";
        sliderPage = homePage.clickLinkByText("Horizontal Slider", SliderPage.class);
        softAssert.assertTrue(sliderPage.validatePage());
        softAssert.assertEquals(sliderPage.moveSlidetoValue(slides), slides);
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Set the slider value")
    void testSetValue() {
        String value = "1.5";
        softAssert.assertEquals(sliderPage.setSlideValue("1.5"), value);
        softAssert.assertAll();
    }
}

package com.qabot.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.stream.IntStream;

public class SliderPage extends MasterPage {
    @FindBy(tagName = "input")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement range;

    @FindBy(tagName = "h3")
    private WebElement header;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate the page")
    public boolean validatePage() {
        return header.getText().equalsIgnoreCase("horizontal slider");
    }

    @Step("Change slider value")
    public String moveSlidetoValue(String input) {
        float value = Float.valueOf(input);
        int steps = (int) (value / .5);
        IntStream.range(0, steps).forEach(s->slider.sendKeys(Keys.ARROW_RIGHT));
        return range.getText();
    }

    @Step("Set the slider value with javascript")
    public String setSlideValue(String value) {
        jse.executeScript("arguments[0].value=arguments[1];" +
                "var evt = document.createEvent('HTMLEvents');" +
                "evt.initEvent('change', true,true);" +
                "arguments[0].dispatchEvent(evt)", slider, value);
        return range.getText();
    }
}

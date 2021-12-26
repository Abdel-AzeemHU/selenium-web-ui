package com.qabot.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BrokenImagePage extends MasterPage {
    @FindBy(tagName = "h3")
    private WebElement header;

    @FindBy(css = "div#content img")
    private List<WebElement> images;

    public BrokenImagePage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify the right page loads")
    public boolean validatePage() {
        return header.getText().equalsIgnoreCase("broken images");
    }

    @Step("validate there are 2 broken images")
    public boolean validateBrokenImages() {
        List<WebElement> broken = images.stream().filter(this::isBrokenImage).collect(Collectors.toList());
        System.out.println("Broken images: ");
        broken.stream().forEach(img-> System.out.println(img.getAttribute("src")));
        return broken.size()==2;
    }

    private boolean isBrokenImage(WebElement element) {
        return element.getAttribute("naturalWidth").equals("0");
    }
}

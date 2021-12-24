package com.qabot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABTestingPage extends MasterPage{

    public ABTestingPage(WebDriver driver){
        super(driver);
    }

//    @FindBy(tagName = "A/B Testing")
//    WebElement abTestingButton;

    @FindBy(css = "div[class='example'] h3")
    public WebElement abTestingHeaderTxt;

    @FindBy(css = "div[class='example'] p")
    public WebElement abTestingContentTxt;




}

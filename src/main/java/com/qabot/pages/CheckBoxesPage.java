package com.qabot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxesPage extends MasterPage{

    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='example'] h3")
    public WebElement checkBoxesTitleTxt;

    @FindBy(xpath = "//input[1]")
    public WebElement checkBox1;

    @FindBy(xpath = "//input[2]")
    public WebElement checkBox2;

}
